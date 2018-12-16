package projectmanager

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class ManagerService {

    SecurityService securityService

    def projectDetails(){
        Users manager = securityService.getUser()
        Project project = Project.findByManager(manager)
        List<Users> memberList = Users.findAllByProject(project)
        return [member:memberList, manager:manager, project:project, count: memberList.size()]
    }

    def taskList(){
        Users manager = securityService.getUser()
        List<Task> taskList = Task.findAllByGivenBy(manager)
        return [task:taskList]
    }

    def getMember(Serializable id) {
        return Users.get(id)
    }

    def getTask(Serializable id) {
        return Task.get(id)
    }

    def removeProjectMember(Users users){
        try {
            users.project=null
            users.save(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }

    def removeTask(Task task){
        try {
            task.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }

    def projectMemberList(){
        Users manager = securityService.getUser()
        Project project = Project.findByManager(manager)
        Users userCompany = Users.findById(manager.id)

        return Users.findAllByRoleAndCompanyAndProject("Member",userCompany.company,project)
    }

    def addTask(GrailsParameterMap params){
        Users manager = securityService.getUser()
        Task task = new Task(params)
        task.givenBy = manager
        task.status = "On process"

        def response = AppUtil.saveResponse(false, task)
        if(task.validate()) {
            response.isSuccess = true
            task.save(flush: true)
        }

        return response
    }

    def taskUpdateList(){
        Users manager = securityService.getUser()
        List<DailyTask> dailyTask = DailyTask.findAllByManager(manager)
        List<DailyTask> task = dailyTask.reverse()
        return [taskUpdate:task]
    }
}
