package projectmanager

class Task {

    Integer id
    String name
    String description
    String status
    Date fromDate
    Date toDate
    Users users
    Users givenBy

    Date dateCreated
    Date lastUpdated

    static belongsTo = [users:Users]
    static constraints = {
        name(nullable: false)
        description(nullable: false)
    }

    static mapping = {
        version(false)
    }
}
