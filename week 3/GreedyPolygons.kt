import kotlin.math.PI
import kotlin.math.tan

fun main() {
    fun getArea(n: Int, l: Int): Double {
        return 0.25 * n * l * l * (1 / (tan(PI / n)))
    }

    fun calcExtra(n: Int, l: Int, d: Int, g: Int): Double {
        val r = g * d
        return r * r * PI + r * l * n
    }

    val cases = readLine()!!.toInt()
    for (i in 1..cases) {
        val prs = readLine()!!.split(" ")
        println(
            getArea(prs[0].toInt(), prs[1].toInt()) + calcExtra(
                prs[0].toInt(),
                prs[1].toInt(),
                prs[2].toInt(),
                prs[3].toInt()
            )
        )
    }


}