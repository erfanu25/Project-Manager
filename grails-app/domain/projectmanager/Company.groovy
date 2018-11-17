package projectmanager

class Company {

    Integer id
    String companyName
    String address
    String number

    Date dateCreated
    Date lastUpdated

    static hasMany = [users: Users, project: Project]


    static constraints = {
    }

    static mapping = {
        version(false)
    }

}
