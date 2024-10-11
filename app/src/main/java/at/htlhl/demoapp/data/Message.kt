package at.htlhl.demoapp.data

data class Message(
    private var sender: User,
    private var text: String,
    private var chat: Chat,
    private var date: Date
) {
    constructor() : this(User(), "", Chat(), Date())

    fun getSender(): User {
        return this.sender
    }

    fun getText(): String {
        return this.text
    }

    fun getChat(): Chat {
        return this.chat
    }

    fun getDate(): Date {
        return this.date
    }

    fun setSender(user: User) {
        this.sender = user
    }

    fun setText(text: String) {
        this.text = text
    }

    fun setChat(chat: Chat) {
        this.chat = chat
    }

    fun setDate(date: Date) {
        this.date = date
    }
}
