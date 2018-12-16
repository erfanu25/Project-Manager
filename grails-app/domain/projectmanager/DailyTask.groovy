package projectmanager

class DailyTask {

    Integer id
    String description
    Users manager
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
