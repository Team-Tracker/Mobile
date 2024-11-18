package at.htlhl.demoapp.data

data class Chat(
    private var chatId: Number,
    private var name: String,
    private var members: Array<User>,
    private var messages: Array<Message>
) {

    constructor() : this(0, "", arrayOf<User>(), arrayOf<Message>())

    fun getChatId(): Number {
        return this.chatId
    }

    fun getName(): String {
        return this.name
    }

    fun getMembers(): Array<User> {
        return this.members
    }

    fun getMessages(): Array<Message> {
        return this.messages
    }

    fun setChatId(value: Number) {
        this.chatId = value
    }

    fun setName(name: String) {
        this.name = name
    }

    fun addMember(user: User) {
        this.members += user
    }

    fun addMessage(message: Message) {
        this.messages += message
    }
}
