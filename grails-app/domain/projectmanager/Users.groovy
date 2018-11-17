package projectmanager

class Users {

    Integer id
    String name
    String email
    String number
    String designation
    String password
    String role
    Company company
    Project project

    Date dateCreated
    Date lastUpdated

    static constraints = {
       // email(email: true, nullable: false, unique: true, blank: false)
        password(blank: false)
        company(nullable: true)
        project(nullable: true)
        designation(nullable: true)
        id(nullable: true)
        number(nullable: true)
    }

    static mapping = {
        version(false)
    }

    def beforeInsert = {
        this.password = this.password.encodeAsMD5()
    }


    def beforeUpdate = {
        this.password = this.password.encodeAsMD5()
    }

}