import kotlin.math.abs
import kotlin.math.sqrt

fun main() {
    val input = readLine()!!.split(" ")
    val x = input[0].toInt()
    val y = input[1].toInt()
    val x1 = input[2].toInt()
    val y1 = input[3].toInt()
    val x2 = input[4].toInt()
    val y2 = input[5].toInt()
    fun calcDist(x: Int, y: Int, x1: Int, y1: Int): Double {
        return sqrt(((x - x1) * (x - x1) + (y - y1) * (y - y1)).toDouble());
    }

    if (x < x1 && y > y2)
        println(calcDist(x, y, x1, y2))
    else if (x > x1 && x < x2 && y > y2)
        println(abs(y - y2).toDouble())
    else if (x > x2 && y > y2)
        println(calcDist(x, y, x2, y2))
    else if (x > x2 && y < y2 && y > y1)
        println(abs(x - x2).toDouble())
    else if (x > x2 && y < y1)
        println(calcDist(x, y, x2, y1))
    else if (x > x1 && x < x2 && y < y1)
        println(abs(y - y1).toDouble())
    else if (x < x1 && y < y1)
        println(calcDist(x, y, x1, y1))
    else if (x < x1 && y > y1 && y < y2)
        println(abs(x - x1).toDouble())
    else
        println(0)

}