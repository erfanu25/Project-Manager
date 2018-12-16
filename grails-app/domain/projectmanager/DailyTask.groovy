package projectmanager

class DailyTask {

    Integer id
    String description
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
