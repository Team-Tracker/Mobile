package at.htlhl.demoapp.data

data class Message(
    private var messageId: Number,
    private var sender: User,
    private var text: String,
    private var date: Date
) {
    constructor() : this(0, User(), "", Date())

    fun getMessageId(): Number {
        return this.messageId
    }

    fun getSender(): User {
        return this.sender
    }

    fun getText(): String {
        return this.text
    }

    fun getDate(): Date {
        return this.date
    }

    fun setMessageId(value: Number) {
        this.messageId = value
    }

    fun setSender(user: User) {
        this.sender = user
    }

    fun setText(text: String) {
        this.text = text
    }

    fun setDate(date: Date) {
        this.date = date
    }
}
