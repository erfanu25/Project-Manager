package projectmanager

import grails.web.servlet.mvc.GrailsParameterMap


class MemberService {

    SecurityService securityService

    boolean userAuthenticated(){
        def authorization = AppUtil.getAppSession().AUTHORIZED
        if (authorization.type == "Member" && authorization.isLoggedIn == true){
            return true
        }
        return false
    }
    def projectDetails(){
        Users user = securityService.getUser()
        Users member = Users.find(user)
        Project project = member.getProject()
        List<Users> memberList = Users.findAllByProject(project)
        return [member:memberList, manager:project.manager, project:project, count: memberList.size(), user:member, companyName:member.company.companyName]
    }

    def taskList(){
        Users member = securityService.getUser()
        List<Task> taskList = Task.findAllByUsers(member)
        return [task:taskList]
    }
    def taskUpdateList(){
        Users member = securityService.getUser()
        List<DailyTask> dailyTask = DailyTask.findAllByUsers(member)
        return [taskUpdate:dailyTask]
    }

    def getTask(Serializable id) {
        return Task.get(id)
    }

    def getDailyTask(Serializable id) {
        return DailyTask.get(id)
    }

    def updateTaskStatus(Task task){
        try {
            task.status="Completed"
            task.save(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }

    def unableTaskStatus(Task task){
        try {
            task.status="On process"
            task.save(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }

    def removeDailyTask(DailyTask dailyTask){
        try {
            dailyTask.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }

    def addTaskUpdate(GrailsParameterMap params){
        Users member = securityService.getUser()
        Users user = Users.find(member)
        Project project = user.getProject()
        DailyTask dailyTask = new DailyTask(params)
        dailyTask.manager = project.manager
        dailyTask.users = user

        def response = AppUtil.saveResponse(false, dailyTask)
        if(dailyTask.validate()) {
            response.isSuccess = true
            dailyTask.save(flush: true)
        }

        return response
    }

}
