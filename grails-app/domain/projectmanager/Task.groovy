package projectmanager

class Task {

    Integer id
    String name
    String description
    String status
    Date fromDate
    Date toDate
    Users users

    Date dateCreated
    Date lastUpdated

    static belongsTo = [users:Users]
    static constraints = {
    }
    static mapping = {
        version(false)
    }
}
