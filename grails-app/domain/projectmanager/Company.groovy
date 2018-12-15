package projectmanager

class Company {

    Integer id
    String companyName
    String address
    String number
    String email

    Date dateCreated
    Date lastUpdated

    static hasMany = [users: Users, project: Project]


    static constraints = {
        email(email: true, nullable: false, unique: true, blank: false)
        companyName(nullable: false, blank: false)
        address(nullable: false, blank: false)
        number(matches: "^[0-9]{7,14}\$")
    }

    static mapping = {
        version(false)
    }

}
