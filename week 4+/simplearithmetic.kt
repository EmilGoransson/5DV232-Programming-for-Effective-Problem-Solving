import java.math.BigDecimal

fun main() {
    val (a, b, c) = readLine()!!.split(' ').map { i -> BigDecimal(i.toInt()).setScale(9) }
    println(a * b / c)
}