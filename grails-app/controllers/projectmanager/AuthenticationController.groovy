package projectmanager

class AuthenticationController {

    PublicService publicService
    AuthenticationService authenticationService
    SecurityService securityService

    def panel() { }
    def signUp(){
        [company: flash.redirectParams]
    }
    def login(){ }

    def register(){
        def response = publicService.register(params)
        if (response.isSuccess) {
            redirect(controller: "owner", action: "index", params: [company:  response.model])
        } else {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "please.provide.correct.info"), false)
            redirect(controller: "authentication", action: "signUp")
        }

    }

    def doLogin() {
        if (securityService.doLogin(params.email, params.password) == "Admin") {
            redirect(controller: "owner", action: "index")
        }
        else if(securityService.doLogin(params.email, params.password) == "Member") {
            redirect(controller: "member", action: "index")
        }
        else if(securityService.doLogin(params.email, params.password) == "Manager") {
            redirect(controller: "manager", action: "index")
        }
        else
        {
            flash.message = AppUtil.infoMessage(g.message(code: "user.name.or.password.is.wrong"), false)
            redirect(controller: "authentication", action: "login")
        }
    }

    def logout() {
        session.invalidate()
        redirect(controller: "authentication", action: "login")
    }

    def changePassword() {
        if (!securityService.isAuthenticated()) {
            redirect(controller: "dashboard", action: "index")
        }
    }

    def doChangePassword() {
        if (securityService.isAuthenticated()) {
            def response = securityService.changePassword(params.password, params.newPassword, params.renewPassword)
            flash.message = response
            if (response.success){
                redirect(action: "panel")
            }else{
                redirect(controller: "authentication", action: "changePassword")
            }
        } else {
            redirect(controller: "authentication", action: "login")
        }
    }
}
