package at.htlhl.demoapp.data

data class Task(
    private var title: String,
    private var description: String,
    private var assignee: User,
    private var startDate: Date,
    private var endDate: Date
) {

    constructor() : this("", "", User(), Date(), Date())

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
