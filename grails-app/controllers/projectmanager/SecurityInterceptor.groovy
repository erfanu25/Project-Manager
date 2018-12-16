package projectmanager


class SecurityInterceptor {

    SecurityService securityService

    SecurityInterceptor() {
        matchAll().excludes(controller: "authentication")

    }

    boolean before() {
        if (!securityService.isAuthenticated()) {
            redirect(controller: "Authentication", action: "panel")
            return false
        }
        return true
    }


}
