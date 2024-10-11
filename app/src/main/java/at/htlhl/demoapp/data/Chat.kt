package at.htlhl.demoapp.data

data class Chat(
    private var name: String,
    private var members: Array<User>
) {

    constructor() : this("", arrayOf<User>())

    fun getName(): String {
        return this.name
    }

    fun getMembers(): Array<User> {
        return this.members
    }

    fun setName(name: String) {
        this.name = name
    }

    fun addMember(user: User) {
        this.members += user
    }
}
