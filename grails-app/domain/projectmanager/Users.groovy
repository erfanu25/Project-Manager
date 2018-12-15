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

    static hasMany = [task:Task]
    static belongsTo = [company:Company]
    static constraints = {
        email(email: true, nullable: false, unique: true, blank: false)
        password(blank: false, nullable: false)
        company(nullable: false)
        project(nullable: true)
        designation(nullable: true)
        id(nullable: true)
        number(nullable: true ,matches: "^[0-9]{7,14}\$" )
    }

    static mapping = {
        version(false)
    }

    def beforeInsert = {
       // this.password = this.password.encodeAsMD5()
    }


    def beforeUpdate = {
      //  this.password = this.password.encodeAsMD5()
    }

}
