package projectmanager

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap


@Transactional
class OwnerService {

    SecurityService securityService

    def register(GrailsParameterMap params){
        Users members = new Users(params)
        members.password = params.password.encodeAsMD5()

        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        members.company = userCompany.company
        def response = AppUtil.saveResponse(false, members)
        if(members.validate()) {
            response.isSuccess = true
            members.save(flush: true)
        }

        return response
    }

    def createProject(GrailsParameterMap params){
        Project project = new Project(params)

        Users admin = securityService.getUser()
        Users company = Users.findById(admin.id)

        project.company = company.company

        def response = AppUtil.saveResponse(false, Project)
        if(project.validate()) {
            response.isSuccess = true
            project.save(flush: true)
        }

        return response
    }

    def memberList() {
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        List<Users> userList = Users.findAllByCompany(userCompany.company)
        return [list:userList, count:Users.count()]
    }

    def projectList() {
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        List<Project> projectList = Project.findAllByCompany(userCompany.company)
        return [list:projectList, count:Project.count()]
    }

    def getMember(Serializable id) {
        return Users.get(id)
    }

    def memberUpdate(Users users, GrailsParameterMap params) {
        users.properties = params
        def response = AppUtil.saveResponse(false, users)
        if (users.validate()) {
            response.isSuccess = true
            users.save(flush:true)
        }
        return response
    }

    def deleteMember(Users users) {
        try {
            users.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }
}
