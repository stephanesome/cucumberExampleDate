import date.MyDate
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*


const val ERRORMSG = "Input Error"

val MonthsMap: HashMap<String, Int> = object : HashMap<String, Int>() {
    /**
     *
     */
    private val serialVersionUID = 1L

    init {
        put("january", 1)
        put("february", 2)
        put("march", 3)
        put("april", 4)
        put("may", 5)
        put("june", 6)
        put("july", 7)
        put("august", 8)
        put("september", 9)
        put("october", 10)
        put("november", 11)
        put("december", 12)
    }
}

fun getNextDate(dateStr: String): String {
    val elts = dateStr.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    if (elts.size == 3) {
        return try {
            val year = elts[0].toInt()
            val month = MonthsMap[elts[1].lowercase(Locale.getDefault())]!!
            val day = elts[2].toInt()
            val date = MyDate(year, month, day)
            val next: MyDate = date.nextDate()
            next.toString()
        } catch (e: Exception) {
            ERRORMSG
        }
    }
    return ERRORMSG
}


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    try {
        print("Enter a date in the format YEAR/MonthName/Day (e.g. 2017/June/10 ): ")
        val dateStr = br.readLine()
        val nextDateStr: String = getNextDate(dateStr)
        if (ERRORMSG == nextDateStr) println("Unable to get next date for $dateStr $ERRORMSG") else println(
            "The date after $dateStr is $nextDateStr"
        )
    } catch (e: IOException) {
        e.printStackTrace()
    }
}
