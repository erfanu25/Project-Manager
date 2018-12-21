package projectmanager

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap


@Transactional
class OwnerService {

    SecurityService securityService
    GlobalConfigService globalConfigService

    boolean userAuthenticated(){
        def authorization = AppUtil.getAppSession().AUTHORIZED
        if (authorization.type == "Admin" && authorization.isLoggedIn == true){
           return true
        }
        return false
    }

    def register(GrailsParameterMap params){

        Users members = new Users(params)
        def response = AppUtil.saveResponse(false, members)
        if(!params.password.equals(params.rePassword)){
            response.isSuccess = false
        }
        else
        {
            members.password = params.password.encodeAsMD5()

            Users admin = securityService.getUser()
            Users userCompany = Users.findById(admin.id)

            members.company = userCompany.company
            if(members.validate()) {
                response.isSuccess = true
                members.save(flush: true)
            }
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

    def memberList(GrailsParameterMap params) {
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        params.max = params.max ?: globalConfigService.itemsPerPage()

        List<Users> userList = Users.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
            eq("company", userCompany.company)
            eq("role", "Member")
        }
        return [list:userList, count:Users.findAllByCompanyAndRole(userCompany.company,"Member").size()]
    }
    def allManagerList() {
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        List<Users> userList = Users.findAllByCompanyAndRole(userCompany.company,"Manager")+ Users.findAllByRoleAndCompany("Admin",userCompany.company)
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
    def projectList(GrailsParameterMap params) {
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        params.max = params.max ?: globalConfigService.itemsPerPage()

        List<Project> projectList = Project.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            eq("company", userCompany.company)
        }
        List<Users> users = Users.findAllByCompany(userCompany.company)
        return [list:projectList, count:users.size(), project: projectList.size(), total: Project.findAllByCompany(userCompany.company).size(), companyName:userCompany.company.companyName]
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
        def response = AppUtil.saveResponse(false, null)
        if(users != null && project != null){
            project.manager=users
            users.project=project
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
        else
        {
            response.isSuccess = false
            return response
        }

    }


    def provideMember(Project project,Users users, GrailsParameterMap params){
        def response = AppUtil.saveResponse(false, null)
        if(users != null && project != null)
        {
            users.project=project
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
        else
        {
            response.isSuccess = false
            return response
        }

    }

    def projectDetails(Serializable id){
        Project project = getProject(id)
        Users manager = project.manager

        List<Users> memberList = Users.findAllByProject(project)
        return [member:memberList, manager:manager, project:project, count: memberList.size()]
    }

    def companyReport(){
        Users admin = securityService.getUser()
        Users userCompany = Users.findById(admin.id)

        List<Users> users = Users.findAllByCompanyAndRole(userCompany.company,"Member")
        List<Project> projectList = Project.findAllByCompany(userCompany.company)
        List<Users> managerList = Users.findAllByCompanyAndRole(userCompany.company,"Manager")
        return [employee:users.size(), project: projectList.size(), manager:managerList.size() ]
    }


}
