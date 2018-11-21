package projectmanager

class AuthenticationController {

    PublicService publicService
    AuthenticationService authenticationService
    SecurityService securityService

    def panel() { }
    def signUp(){ }
    def login(){ }

    def register(){
        def response = publicService.register(params)
        if (response.isSuccess) {
            redirect(controller: "owner", action: "index", params: [company:  response.model])
        } else {

            redirect(controller: "authentication", action: "panel")

        }
    }

    def doLogin() {
        if (securityService.doLogin(params.email, params.password)) {
            redirect(controller: "owner", action: "index")
        } else {
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

            if (response.success){
                redirect(controller: "dashboard", action: "index")
            }else{
                redirect(controller: "authentication", action: "changePassword")
            }
        } else {
            redirect(controller: "authentication", action: "login")
        }
    }
}
