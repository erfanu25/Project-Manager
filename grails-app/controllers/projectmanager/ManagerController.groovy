package projectmanager

class ManagerController {
    ManagerService managerService
    def index() {
        def response = managerService.projectDetails()
        [project: response.project]
    }

    def teamMembers(){
        def response = managerService.projectDetails()
        [member: response.member, manager:response.manager, project:response.project, count:response.count]
    }

    def removeProjectMember(Integer id){
        def response = managerService.getMember(id)
        Project project = response.project
        if (!response){
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.remove"), false)
            redirect(controller: "manager", action: "teamMembers", id:project.id)
        }else{
            def check = managerService.removeProjectMember(response)
            if (!check){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.remove"), false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "removed"))
            }
            redirect(controller: "manager", action: "teamMembers", id:project.id)
        }
    }

    def assignTask(){

    }

    def addTask(){
        def response = managerService.addTask(params)
        if (response.isSuccess) {
            flash.message = AppUtil.infoMessage(g.message(code: "task.added"))
            redirect(controller: "manager", action: "taskList")
        } else {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "operation.failed"), false)
            redirect(controller: "manager", action: "assignTask")
        }
    }

    def taskList(){
        def response = managerService.taskList()
        [task: response.task]
    }

    def removeTask(Integer id) {
        def response = managerService.getTask(id)
        if (!response){
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.delete"), false)
            redirect(controller: "manager", action: "taskList")
        }else{
            response = managerService.removeTask(response)
            if (!response){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.delete"), false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "deleted"))
            }
            redirect(controller: "manager", action: "taskList")
        }
    }

    def dailyTaskUpdate(){
        def response = managerService.taskUpdateList()
        [taskUpdate: response.taskUpdate]
    }

    def projectReport(){
        def response = managerService.projectDetails()
        [member: response.member, manager:response.manager, project:response.project, count:response.count]
    }
    def teamReport(){

    }
    def taskReport(){

    }
}
