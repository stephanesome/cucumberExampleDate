package date


class MyDate(year: Int, month: Int, day: Int) {
    // GETTERS and SETTERS
    /* Data fields */
    private var yEAR = 0
    private var mONTH = 0
    private var dAY = 0

    /* String correspondent used for displaying months */
    private var mONTHNAMES = arrayOf(
        "January", "February", "March", "April",
        "May", "June", "July", "August", "September",
        "October", "November", "December"
    )

    //
    // CONSTRUCTOR
    //
    init {
        setYear(year)
        setMonth(month)
        setDay(day)
    }

    /**
     * Check validity of the day when creating a new Date.
     * DAY must be greater or equal to 1 and
     * - less or equal to 31 for months with 31 days
     * - less or equal to 30 for months with 30 days,
     * - less or equal to 29 for February if YEAR is leap
     * - less or equal to 30 for February if YEAR is non-leap
     */
    private fun setDay(day: Int) {
        require(day >= 1) { "DAY must greater or equal to 1." }
        require(day <= 31) { "DAY must less or equal to 31." }
        require(!(isThirtyDayMonth && day > 30)) { "DAY must less than 30 for month " + monthName() }
        require(!(isFebruary && isLeapYear && day > 29)) { "DAY must less than 29 for month " + monthName() + " on a leap year." }
        require(!(isFebruary && !isLeapYear && day > 28)) { "DAY must less than 28 for month " + monthName() + " on a non leap year." }
        dAY = day
    }

    /**
     * Check validity of the month when creating a new Date. MONTH must be between 1 and 12.
     */
    private fun setMonth(month: Int) {
        require(!(month < 1 || month > 12)) { "MONTH must be between 1 and 12." }
        mONTH = month
    }

    /**
     * Check validity of the year when creating a new Date. YEAR must be greater than 0
     */
    private fun setYear(year: Int) {
        require(year >= 0) { "YEAR must be greater or equal to 0." }
        yEAR = year
    }
    // Class methods
    /**
     * Returns the date of the day following that date.
     *
     */
    fun nextDate(): MyDate {
        var nextYear = yEAR
        var nextMonth = mONTH
        var nextDay = dAY + 1
        if (isEndOfMonth) {
            nextDay = 1
            if (mONTH == 12) {
                nextYear++
                nextMonth = 1
            } else {
                nextMonth++
            }
        }
        return MyDate(nextYear, nextMonth, nextDay)
    }

    private val isEndOfMonth: Boolean
        /**
         *
         * Check if the date is a end of a month.
         */
        get() {
            val leap = isLeapYear
            return ((dAY == 31) || (dAY == 30 && isThirtyDayMonth) ||
                    (isFebruary && ((dAY == 29 && leap) || (dAY == 28 && !leap))))
        }
    private val isFebruary: Boolean
        /**
         * returns true if MONTH is February.
         */
        get() = mONTH == 2
    private val isThirtyDayMonth: Boolean
        /**
         * returns true if MONTH has 30 days.
         */
        get() = (mONTH == 4) || (mONTH == 6) || (mONTH == 9) || (mONTH == 11)
    private val isLeapYear: Boolean
        /**
         * returns true if YEAR is leap.
         * A leap year is divisible by 4 unless it is a century year. In that case, it must be divisible by 400.
         */
        get() = if (yEAR % 100 == 0) {
            yEAR % 400 == 0
        } else yEAR % 4 == 0

    /**
     * Returns the name of MONTH
     */
    private fun monthName(): String {
        return mONTHNAMES[mONTH - 1]
    }

    override fun toString(): String {
        return yEAR.toString() + "/" + monthName() + "/" + dAY
    }

/*    override fun equals(other: Any?): Boolean {
        if (other !is Date) return false
        return yEAR == other.yEAR && mONTH == other.mONTH && dAY == other.dAY
    }

    override fun hashCode(): Int {
        var result = yEAR
        result = 31 * result + mONTH
        result = 31 * result + dAY
        result = 31 * result + MONTHNAMES.contentHashCode()
        return result
    }*/
}
