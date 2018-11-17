package projectmanager

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class PublicService {

    def register(GrailsParameterMap params){
        Company company = new Company()
        company.companyName = params.companyName
        company.address = params.address
        company.number = params.number

        def companyResponse = AppUtil.saveResponse(false, company)
        if(company.validate()) {
            company.save(flush: true)

            Users users = new Users()
            users.name = params.ownerName
            users.password = params.password
            users.email = params.email
            users.role = "Admin"
            users.company = company
            users.number = params.number
            users.designation = "Administrator"

            if(users.validate())
            {
                companyResponse.isSuccess = true
                users.save(flush: true)
            }
        }

        return companyResponse
    }
}