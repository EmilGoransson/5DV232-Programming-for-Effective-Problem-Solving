import java.text.SimpleDateFormat
import java.util.*

fun main() {
    fun String.permute(result: String = "", seen: HashSet<String> = HashSet()): List<String> =
        if (isEmpty()) {
            if (seen.add(result)) listOf(result) else emptyList()
        } else {
            flatMapIndexed { i, c -> removeRange(i, i + 1).permute(result + c, seen) }
        }

    val count = readLine()!!.toInt()
    repeat(count) {
        val date = readLine()!!.replace(" ", "")
        val dateFormat = SimpleDateFormat("ddMMyyyy")
        dateFormat.isLenient = false
        var strDate: Date
        val bornDate: Date = dateFormat.parse("31121999")
        val dates = date.permute()
        val newDates = ArrayList<Date>()
        dates.forEach { i ->
            try {
                strDate = dateFormat.parse(i);
                if (strDate.after(bornDate)) {
                    newDates.add(strDate)
                }
            } catch (_: Exception) {

            }
        }
        val countDates = newDates.count()
        val sortedDates = newDates.sorted()
        val dateFormatOutput = SimpleDateFormat("dd MM yyyy")
        try {
            val earliestDate = dateFormatOutput.format(sortedDates[0])
            println("$countDates $earliestDate")
        } catch (e: Exception) {
            println("0")
        }
    }
}