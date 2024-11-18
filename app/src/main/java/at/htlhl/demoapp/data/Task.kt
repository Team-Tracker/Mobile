package at.htlhl.demoapp.data

data class Task(
    private var taskId: Number,
    private var title: String,
    private var description: String,
    private var assignee: User,
    private var startDate: Date,
    private var endDate: Date
) {

    constructor() : this(0, "", "", User(), Date(), Date())

    fun getTaskId(): Number {
        return this.taskId
    }

    fun getTitle(): String {
        return this.title
    }

    fun getDescription(): String {
        return this.description
    }

    fun getAssignee(): User {
        return this.assignee
    }

    fun getStartDate(): Date {
        return this.startDate
    }

    fun getEndDate(): Date {
        return this.endDate
    }

    fun setTaskId(value: Number) {
        this.taskId = value
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun setAssignee(user: User) {
        this.assignee = user
    }

    fun setStartDate(date: Date) {
        this.startDate = date
    }

    fun setEndDate(date: Date) {
        this.endDate = date
    }
}
