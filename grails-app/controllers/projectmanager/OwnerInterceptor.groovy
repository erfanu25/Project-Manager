package projectmanager


class OwnerInterceptor {

    OwnerService ownerService
    boolean before() {
        if (!ownerService.userAuthenticated()) {
            redirect(controller: "Authentication", action: "panel")
            return false
        }
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
