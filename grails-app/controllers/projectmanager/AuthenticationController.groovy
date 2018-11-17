package projectmanager

class AuthenticationController {

    PublicService publicService
    AuthenticationService authenticationService

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
        if (authenticationService.doLogin(params.email, params.password)) {
            redirect(controller: "owner", action: "index")
        } else {
            redirect(controller: "authentication", action: "login")
        }
    }
}
