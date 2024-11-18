package at.htlhl.demoapp.data

data class Team(
    private var teamId: Number,
    private var name: String,
    private var tasks: Array<Task>,
    private var members: Array<User>,
    private var owner: User
) {

    constructor() : this(0, "", arrayOf<Task>(), arrayOf<User>(), User())

    fun getTeamId(): Number{
        return this.teamId
    }

    fun getName(): String {
        return this.name
    }

    fun getTasks(): Array<Task> {
        return this.tasks
    }

    fun getMembers(): Array<User> {
        return this.members
    }

    fun getOwner(): User {
        return this.owner
    }

    fun setTeamId(value: Number) {
        this.teamId = value
    }

    fun setName(name: String) {
        this.name = name
    }

    fun addTask(task: Task) {
        this.tasks += task
    }

    fun addMember(user: User) {
        this.members += user
    }

    fun setOwner(user: User) {
        this.owner = user
    }
}


