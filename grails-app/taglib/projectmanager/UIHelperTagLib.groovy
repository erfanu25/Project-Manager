package projectmanager

class UIHelperTagLib {
    static namespace = "UIHelper"

    def publicActionMenu = { attrs, body ->

        out << g.link(controller: "Authentication", action: "login", class:"nav-link"){g.message(code:"Log In")}+"    "
        out << g.link(controller: "Authentication", action: "signUp",class:"nav-link"){g.message(code:"Sign Up")}+"    "
    }

    def ownerActionMenu = { attrs, body ->

        out << g.link(controller: "Authentication", action: "panel", class:"nav-link"){g.message(code:"Log Out")}+"    "
        out << g.link(controller: "Authentication", action: "signUp",class:"nav-link"){g.message(code:"Change Password")}+"    "
    }

    def appMenu = { attrs, body ->
        [
                [controller: "Owner", action: "addMember", name: "add.member"],
                [controller: "Owner", action: "showMember", name: "members"],
                [controller: "Owner", action: "index", name: "assign.manager"],
                [controller: "Owner", action: "createProject", name: "create.project"],
                [controller: "Owner", action: "projectList", name: "projects"],
                [controller: "Owner", action: "index", name: "progress.report"]

        ].each { menu ->
            out << '<li class="memberList-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }


}
