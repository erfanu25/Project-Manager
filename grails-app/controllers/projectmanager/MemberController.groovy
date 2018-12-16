package projectmanager

class MemberController {
    MemberService memberService
    def index() {
        def response = memberService.projectDetails()
        [project: response.project, user:response.user]
    }

    def viewAssignTask(){
        def response = memberService.taskList()
        [task: response.task]
    }

    def giveTaskUpdate(){

    }

    def addTaskUpdate(){
        def response = memberService.addTaskUpdate(params)
        if (response.isSuccess) {
            flash.message = AppUtil.infoMessage(g.message(code: "task.update.added"))
            redirect(controller: "member", action: "taskUpdateList")
        } else {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "operation.failed"), false)
            redirect(controller: "member", action: "giveTaskUpdate")
        }
    }

    def taskUpdateList(){
        def response = memberService.taskUpdateList()
        [taskUpdate: response.taskUpdate]
    }

    def updateTaskStatus(Integer id){
        def response = memberService.getTask(id)
        if (!response){
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
            redirect(controller: "member", action: "viewAssignTask")
        }else{
            def check = memberService.updateTaskStatus(response)
            if (!check){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "updated"))
            }
            redirect(controller: "member", action: "viewAssignTask")
        }
    }

    def unableTaskStatus(Integer id){
        def response = memberService.getTask(id)
        if (!response){
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
            redirect(controller: "member", action: "viewAssignTask")
        }else{
            def check = memberService.unableTaskStatus(response)
            if (!check){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "updated"))
            }
            redirect(controller: "member", action: "viewAssignTask")
        }
    }

    def removeDailyTask(Integer id){
        def response = memberService.getDailyTask(id)
        if (!response){
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.remove"), false)
            redirect(controller: "member", action: "taskUpdateList")
        }else{
            def check = memberService.removeDailyTask(response)
            if (!check){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.remove"), false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "removed"))
            }
            redirect(controller: "member", action: "taskUpdateList")
        }
    }

    def editDailyTask(){

    }

}
