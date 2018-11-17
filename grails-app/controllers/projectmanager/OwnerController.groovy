package projectmanager

class OwnerController {

    OwnerService ownerService

    def index() {

    }

    def addMember() { }

    def regMember() {

        def response = ownerService.register(params)
        if (response.isSuccess) {

            redirect(controller: "owner", action: "showMember")
        } else {

            redirect(controller: "owner", action: "index")
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
}
