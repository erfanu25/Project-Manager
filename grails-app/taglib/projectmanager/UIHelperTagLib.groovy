package projectmanager

class UIHelperTagLib {
    static namespace = "UIHelper"

    OwnerService ownerService
    def publicActionMenu = { attrs, body ->

        out << g.link(controller: "Authentication", action: "login", class:"nav-link"){g.message(code:"Log In")}+"    "
        out << g.link(controller: "Authentication", action: "signUp",class:"nav-link"){g.message(code:"Sign Up")}+"    "
    }

    def ownerActionMenu = { attrs, body ->

        out << g.link(controller: "Authentication", action: "logout", class:"nav-link"){g.message(code:"Log Out")}+"    "
        out << g.link(controller: "Authentication", action: "changePassword",class:"nav-link"){g.message(code:"Change Password")}+"    "
    }

    def appMenu = { attrs, body ->
        [
                [controller: "Owner", action: "addMember", name: "add.member"],
                [controller: "Owner", action: "showMember", name: "members"],
                [controller: "Owner", action: "assignManager", name: "assign.manager"],
                [controller: "Owner", action: "createProject", name: "create.project"],
                [controller: "Owner", action: "projectList", name: "projects"],
                [controller: "Owner", action: "index", name: "progress.report"]

        ].each { menu ->
            out << '<li class="memberList-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }

//    def projectList = { attrs, body ->
//        String project = attrs.project ?: "projectList"
//        out << g.select(class:"dropdown", optionValue: "name", optionKey: "id", value: attrs.value, name: project, from: ownerService.projectList())
//    }

    def managerList = { attrs, body ->
        String manager = attrs.manager ?: "managerList"
        out << g.select(class:"dropdown", optionValue: "name", optionKey: "id", value: attrs.value, name: manager, from: ownerService.memberList())
    }


}
