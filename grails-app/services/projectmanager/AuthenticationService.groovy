package projectmanager

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class AuthenticationService {


    def doLogin(String email, String password){
//        password = password.encodeAsMD5()
        Users users = Users.findByEmailAndPassword(email, password)
        if (users){
          //  setAuthorization(admin)
            return true
        }
        else
        {
            return false
        }

    }

}
