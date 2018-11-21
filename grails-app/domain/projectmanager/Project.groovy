package projectmanager

class Project {

    Integer id
    String name
    String type
    String category
    Company company
    Users manager

    static hasMany = [users: Users]

    Date dateCreated
    Date lastUpdated

    static constraints = {
        company(nullable: true)
        users(nullable: true)
        manager(nullable: true)
    }

    static mapping = {
        version(false)
    }
}
