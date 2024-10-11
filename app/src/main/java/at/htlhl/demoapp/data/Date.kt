package at.htlhl.demoapp.data

data class Date(
    private var day: Number,
    private var month: Number,
    private var year: Number,
    private var hour: Number,
    private var minute: Number,
    private var second: Number
) {

    constructor() : this(0, 0, 0, 0, 0, 0)

    fun getYear(): Number {
        return this.year
    }

    fun getMonth(): Number {
        return this.month
    }

    fun getDay(): Number {
        return this.day
    }

    fun getHour(): Number {
        return this.hour
    }

    fun getMinute(): Number {
        return this.minute
    }

    fun getSecond(): Number {
        return this.second
    }

    fun setYear(year: Number) {
        this.year = year
    }

    fun setMonth(month: Number) {
        this.month = month
    }

    fun setDay(day: Number) {
        this.day = day
    }

    fun setHour(hour: Number) {
        this.hour = hour
    }

    fun setMinute(minute: Number) {
        this.minute = minute
    }

    fun setSecond(second: Number) {
        this.second = second
    }

    override fun toString(): String {
        var dateString: String = ""
        dateString
            .plus(day).plus('.').plus(month).plus('.').plus(year).plus('-')
            .plus(hour).plus(':').plus(minute).plus(':').plus(second)

        return dateString
    }
}
