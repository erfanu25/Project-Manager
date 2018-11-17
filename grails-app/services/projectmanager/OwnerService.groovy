package projectmanager

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class OwnerService {

    def register(GrailsParameterMap params){
        Users members = new Users(params)
       // members.company =  [have to implement]
        def response = AppUtil.saveResponse(false, members)
        if(members.validate()) {
            response.isSuccess = true
            members.save(flush: true)
        }

        return response
    }

    def createProject(GrailsParameterMap params){
        Project project = new Project(params)
        // members.company =  [have to implement]
        def response = AppUtil.saveResponse(false, Project)
        if(project.validate()) {
            response.isSuccess = true
            project.save(flush: true)
        }

        return response
    }

    def memberList() {
        List<Users> userList = Users.list()
        return [list:userList, count:Users.count()]
    }

    def projectList() {
        List<Project> projectList = Project.list()
        return [list:projectList, count:Project.count()]
    }
}
