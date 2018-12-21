package projectmanager

class UIHelperTagLib {
    static namespace = "UIHelper"

    OwnerService ownerService
    PublicService publicService
    ManagerService managerService

    def renderErrorMessage = { attrs, body ->
        def model = attrs.model
        String fieldName = attrs.fieldName
        String errorMessage = attrs.errorMessage? g.message(code: attrs.errorMessage): g.message(code: "invalid.input")
        if (model && model.errors && model.errors.getFieldError(fieldName)){
            out << "<small class='form-text text-danger''><strong>${errorMessage}</strong></small>"
        }
    }

    def publicActionMenu = { attrs, body ->
        out << g.link(controller: "Authentication", action: "login", class:"nav-link "){g.message(code:"Log In")}+"    "
        out << g.link(controller: "Authentication", action: "signUp",class:"nav-link"){g.message(code:"Sign Up")}+"    "
    }

    def ownerActionMenu = { attrs, body ->
        out << '<li class="nav-item dropdown show">'
        out << g.link(class:"nav-link dropdown-toggle", "data-toggle":"dropdown"){publicService.getMemberName()}
        out << '<div class="dropdown-menu">'
        out << g.link(controller: "authentication", action: "changePassword", class: "dropdown-item"){g.message(code:"change.password")}
        out << g.link(controller: "authentication", action: "logout", class: "dropdown-item"){g.message(code:"logout")}
        out << "</div></li>"
    }

    def appMenu = { attrs, body ->
        [
                [controller: "Owner", action: "index", name: "dashboard"],
                [controller: "Owner", action: "addMember", name: "add.member"],
                [controller: "Owner", action: "showMember", name: "members"],
                [controller: "Owner", action: "showManagers", name: "managers"],
                [controller: "Owner", action: "createProject", name: "create.project"],
                [controller: "Owner", action: "projectList", name: "projects"],
                [controller: "Owner", action: "assignManager", name: "assign.manager"],
                [controller: "Owner", action: "assignMember", name: "assign.member"],
                [controller: "Owner", action: "companyReport", name: "progress.report"]

        ].each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }

    def progressMenu = { attrs, body ->
        [
                [controller: "Owner", action: "companyReport", name: "companyReport"],
                [controller: "Owner", action: "progressReport", name: "projectProgress"],
                [controller: "Owner", action: "allProjectReport", name: "allProject"],
                [controller: "Owner", action: "index", name: "Back"],

        ].each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }

    def managerProgressMenu = { attrs, body ->
        [
                [controller: "Manager", action: "teamReport", name: "teamReport"],
                [controller: "Manager", action: "taskReport", name: "taskReport"],
                [controller: "Manager", action: "index", name: "Back"],

        ].each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }
    def managerMenu = { attrs, body ->
        [
                [controller: "Manager", action: "index", name: "dashboard"],
                [controller: "Manager", action: "teamMembers", name: "teamMembers"],
                [controller: "Manager", action: "assignTask", name: "assignTask"],
                [controller: "Manager", action: "taskList", name: "taskList"],
                [controller: "Manager", action: "dailyTaskUpdate", name: "dailyTaskUpdate"],
                [controller: "Manager", action: "taskReport", name: "progress.report"]

        ].each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }

    def memberMenu = { attrs, body ->
        [
                [controller: "Member", action: "index", name: "dashboard"],
                [controller: "Member", action: "viewAssignTask", name: "viewAssignTask"],
                [controller: "Member", action: "giveTaskUpdate", name: "giveTaskUpdate"],
                [controller: "Member", action: "taskUpdateList", name: "taskUpdateList"],

        ].each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }
    def projectList = { attrs, body ->
        String name = attrs.name ?: "projectList"
        out << g.select(class:"dropdown",optionValue: "name", optionKey: "id", value: attrs.name, name: name, from: ownerService.listOfProjectForManager())
    }

    def managerList = { attrs, body ->
        String name = attrs.name ?: "managerList"
        out << g.select(class:"form-control", multiple: "multiple",optionValue: "name", optionKey: "id",value: attrs.value, name: name, from: ownerService.managerList())
    }

    def projectListForMember = { attrs, body ->
        String name = attrs.name ?: "projectList"
        out << g.select(class:"dropdown",optionValue: "name", optionKey: "id", value: attrs.name, name: name, from: ownerService.listOfProjectForMember())
    }

    def memberList = { attrs, body ->
        String name = attrs.name ?: "memberList"
        out << g.select(class:"form-control", multiple: "multiple",optionValue: "name", optionKey: "id",value: attrs.value, name: name, from: ownerService.memberListForAddProject())
    }

    def projectMemberList = { attrs, body ->
        String name = attrs.name ?: "memberList"
        out << g.select(class:"dropdown", optionValue: "name", optionKey: "id",value: attrs.value, name: name, from: managerService.projectMemberList())
    }

}
