package projectmanager

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class PublicService {

    SecurityService securityService

    def register(GrailsParameterMap params){
        Company company = new Company()
        company.companyName = params.companyName
        company.address = params.address
        company.number = params.number
        company.email = params.email

        def companyResponse = AppUtil.saveResponse(false, company)
        if(company.validate()) {
            company.save(flush: true)

            Users users = new Users()
            users.name = params.ownerName
            users.password = params.password.encodeAsMD5()
            users.email = params.email
            users.role = "Admin"
            users.company = company
            users.number = params.number
            users.designation = "Administrator"

            if(users.validate())
            {
                companyResponse.isSuccess = true
                users.save(flush: true)

                securityService.setAuthorization(users)

            }
        }

        return companyResponse
    }
}
