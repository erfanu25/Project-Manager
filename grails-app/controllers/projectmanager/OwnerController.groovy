package projectmanager

class OwnerController {

    OwnerService ownerService

    def index() {

    }
    def assignManager() { }
    def addMember() {
        [member: flash.redirectParams]
    }

    def regMember() {

        def response = ownerService.register(params)
        if (response.isSuccess) {
            flash.message = AppUtil.infoMessage(g.message(code: "new.member.added"))
            redirect(controller: "owner", action: "showMember")
        } else {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "please.provide.correct.info"), false)
            redirect(controller: "owner", action: "addMember")
        }
    }

    def editMember(Integer id) {
        if (flash.redirectParams) {
            [member: flash.redirectParams]
        } else {
            def response = ownerService.getMember(id)
            if (!response) {

                redirect(controller: "owner", action: "showMember")
            } else {
                [member: response]
            }
        }
    }

    def createProject(){}

    def saveProject() {

        def response = ownerService.createProject(params)
        if (response.isSuccess) {
            flash.message = AppUtil.infoMessage(g.message(code: "new.project.added"))
            redirect(controller: "owner", action: "projectList")
        } else {
            flash.message = AppUtil.infoMessage(g.message(code: "project.create.failed"), false)
            redirect(controller: "owner", action: "index")

        }

    }

    def showMember(){

        def response = ownerService.memberList()
        [user: response.list, total:response.count]
    }

    def projectList(){
        def response = ownerService.projectList()
        [project: response.list, total:response.count]
    }

    def memberUpdate() {
        def response = ownerService.getMember(params.id)
        if (!response){

            redirect(controller: "owner", action: "editMember")
        }else{
            response = ownerService.memberUpdate(response, params)
            if (!response.isSuccess){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
                redirect(controller: "owner", action: "editMember")
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "updated"))
                redirect(controller: "owner", action: "showMember")
            }
        }
    }

    def deleteMember(Integer id) {
        def response = ownerService.getMember(id)
        if (!response){

            redirect(controller: "owner", action: "showMember")
        }else{
            response = ownerService.deleteMember(response)
            if (!response){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.delete"), false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "deleted"))
            }
            redirect(controller: "owner", action: "showMember")
        }
    }

    def editProject(Integer id){
        if (flash.redirectParams) {
            [member: flash.redirectParams]
        } else {
            def response = ownerService.getProject(id)
            if (!response) {

                redirect(controller: "owner", action: "projectList")
            } else {
                [project: response]
            }
        }
    }
    def projectUpdate(){
        def response = ownerService.getProject(params.id)
        if (!response){

            redirect(controller: "owner", action: "editProject")
        }else{
            response = ownerService.projectUpdate(response, params)
            if (!response.isSuccess){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
                redirect(controller: "owner", action: "editProject")
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "updated"))
                redirect(controller: "owner", action: "projectList")
            }
        }
    }

    def deleteProject(Integer id){
        def response = ownerService.getProject(id)
        if (!response){

            redirect(controller: "owner", action: "projectList")
        }else{
            response = ownerService.deleteProject(response)
            if (!response){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.delete"), false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "deleted"))
            }
            redirect(controller: "owner", action: "projectList")
        }
    }
}
