package projectmanager

import grails.transaction.Transactional

@Transactional
class SecurityService {

    private static final String AUTHORIZED = "AUTHORIZED"

    boolean isAuthenticated(){
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        if (authorization && authorization.isLoggedIn){
            return true
        }
        return false
    }

    def setAuthorization(Users users){
        def authorization = [isLoggedIn: true, user: users]
        AppUtil.getAppSession()[AUTHORIZED] = authorization
    }

    def doLogin(String email, String password){
        password = password.encodeAsMD5()
        Users user = Users.findByEmailAndPassword(email, password)
        if (user){
            setAuthorization(user)
            return user.role
        }
        return false
    }

    def getUser(){
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        return authorization?.user
    }

    def getUserName(){
        def user = getUser()
        return "${user.name}"
    }

    def changePassword(String oldPassword, String newPassword, String retrievePassword){
        Users user = getUser()
        if (!newPassword || !retrievePassword || !newPassword.equals(retrievePassword)) {
            println("not match")
        } else if (user  && !user.password.equals(oldPassword.encodeAsMD5())) {
            println("incorrect old password")
        } else {
            user  = user.get(user.id)
            user.password = newPassword.encodeAsMD5()
            user.save(flush: true)
            setAuthorization(user)
        }
        return AppUtil.infoMessage("Password Changed")
    }


}
