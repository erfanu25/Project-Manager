package projectmanager

class OwnerController {

    OwnerService ownerService

    def index() {

    }
    def assignManager() { }
    def addMember() { }

    def regMember() {

        def response = ownerService.register(params)
        if (response.isSuccess) {

            redirect(controller: "owner", action: "showMember")
            flash.message = "successfully deleted object"
        } else {

            redirect(controller: "owner", action: "index")
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

            redirect(controller: "owner", action: "projectList")
        } else {

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

                redirect(controller: "owner", action: "editMember")
            }else{

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
                println("unable")
            }else{
                println("able")
            }
            redirect(controller: "owner", action: "showMember")
        }
    }
}
