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

        List<Users> userList = Users.findAllByCompanyAndRole(userCompany.company,"Member")
        return [list:userList, count:Users.count()]
    }
    def allManagerList() {
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        List<Users> userList = Users.findAllByCompanyAndRole(userCompany.company,"Manager")
        return [list:userList, count:Users.count()]
    }

    def managerList(){
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        return Users.findAllByRoleAndCompanyAndProject("Manager",userCompany.company,null)+ Users.findAllByRoleAndCompanyAndProject("Admin",userCompany.company,null)
    }
    def memberListForAddProject(){
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        return Users.findAllByRoleAndCompanyAndProject("Member",userCompany.company,null)
    }
    def listOfProjectForManager(){
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        return Project.findAllByCompanyAndManager(userCompany.company,null)
    }

    def listOfProjectForMember(){
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        return Project.findAllByCompany(userCompany.company)
    }
    def projectList() {
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        List<Users> users = Users.findAllByCompany(userCompany.company)
        List<Project> projectList = Project.findAllByCompany(userCompany.company)
        return [list:projectList, count:users.size()]
    }

    def getMember(Serializable id) {
        return Users.get(id)
    }

    def getProject(Serializable id){
        return Project.get(id)
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

    def projectUpdate(Project project, GrailsParameterMap params){
        project.properties = params
        def response = AppUtil.saveResponse(false, project)
        if (project.validate()) {
            response.isSuccess = true
            project.save(flush:true)
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

    def deleteProject(Project project){
        try {
            project.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
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

    def removeProjectManager(Project project){
        try {
            Users users = project.manager
            users.project = null
            users.save(flush: true)
            project.manager=null
            project.save(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }
    def provideManager(Project project,Users users, GrailsParameterMap params){

        project.manager=users
        users.project=project
        def response = AppUtil.saveResponse(false, project)
        if (project) {
            response.isSuccess = true
            project.save(flush:true)
            users.save(flush:true)
        }
        else
        {
            response.isSuccess = false
        }
        return response
    }


    def provideMember(Project project,Users users, GrailsParameterMap params){

        users.project=project
        def response = AppUtil.saveResponse(false, project)
        if (project) {
            response.isSuccess = true
            users.save(flush:true)
        }
        else
        {
            response.isSuccess = false
        }
        return response
    }

    def projectDetails(Serializable id){
        Project project = getProject(id)
        Users manager = project.manager

        List<Users> memberList = Users.findAllByProject(project)
        return [member:memberList, manager:manager, project:project, count: memberList.size()]
    }

}
