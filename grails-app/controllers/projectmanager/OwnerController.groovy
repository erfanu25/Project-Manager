package projectmanager

import grails.converters.JSON

class OwnerController {

    OwnerService ownerService

    def index() {
        def response = ownerService.projectList(params)
        [project: response.list, total:response.count, companyName: response.companyName]
    }
    def assignManager() { }

    def assignMember(){}

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
            redirect(controller: "owner", action: "createProject")

        }

    }

    def showMember(){
        def response = ownerService.memberList(params)
        [user: response.list, total:response.count]
    }
    def showManagers(){

        def response = ownerService.allManagerList()
        [user: response.list, total:response.count]
    }

    def projectList(){
        def response = ownerService.projectList(params)
        [project: response.list, total:response.total]
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

    def deleteManager(Integer id) {
        def response = ownerService.getMember(id)
        if (!response){

            redirect(controller: "owner", action: "showManagers")
        }else{
            response = ownerService.deleteMember(response)
            if (!response){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.delete"), false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "deleted"))
            }
            redirect(controller: "owner", action: "showManagers")
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

    def provideManager(){
        def response = ownerService.getProject(params.project)
        def managerResponse = ownerService.getMember(params.manager)
        if (!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "manager.assigned.failed"), false)
            redirect(controller: "owner", action: "assignManager")
        } else {
            response = ownerService.provideManager(response,managerResponse, params)
            if (!response.isSuccess) {
                flash.message = AppUtil.infoMessage(g.message(code: "manager.assigned.failed"), false)
                redirect(controller: "owner", action: "assignManager")
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "manager.assigned"))
                redirect(controller: "owner", action: "assignManager")
            }
        }
    }

    def provideMember(){
        def response = ownerService.getProject(params.project)
        def memberResponse = ownerService.getMember(params.member)
        if (!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "member.assigned.failed"), false)
            redirect(controller: "owner", action: "assignMember")
        } else {
            response = ownerService.provideMember(response,memberResponse, params)
            if (!response.isSuccess) {
                flash.message = AppUtil.infoMessage(g.message(code: "member.assigned.failed"), false)
                redirect(controller: "owner", action: "assignMember")
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "member.assigned"))
                redirect(controller: "owner", action: "assignMember")
            }
        }
    }

    def projectDetails(Integer id){

        if(id){
            def response = ownerService.projectDetails(id)
            [member: response.member, manager:response.manager, project:response.project, count:response.count]
        }
        else
        {
            redirect(controller: "authentication", action: "panel")
        }

    }

    def removeProjectMember(Integer id){
        def response = ownerService.getMember(id)
        Project project = response.project
        if (!response){
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.remove"), false)
            redirect(controller: "owner", action: "projectDetails", id:project.id)
        }else{
            def check = ownerService.removeProjectMember(response)
            if (!check){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.remove"), false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "removed"))
            }
            redirect(controller: "owner", action: "projectDetails", id:project.id)
        }
    }

    def removeManager(Integer id){
        def response = ownerService.getProject(id)
        if (!response){
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.remove"), false)
            redirect(controller: "owner", action: "projectDetails", id:id)
        }else{
            def check = ownerService.removeProjectManager(response)
            if (!check){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.remove"), false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "removed"))
            }
            redirect(controller: "owner", action: "projectDetails", id:id)
        }
    }

    def companyReport(){
        def response = ownerService.companyReport()
        [employee: response.employee, projectCount:response.project, manager:response.manager ]
    }

    def allProjectReport(){
        def response = ownerService.projectList(params)
        [project:response.list]
    }

    def progressReport(){
        def response = ownerService.projectList(params)
        [project:response.list]
    }
}
