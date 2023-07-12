import java.math.BigDecimal

fun main() {
    val (a, b, c) = readLine()!!.split(' ').map(String::toInt)
    val A = BigDecimal(a).setScale(18)
    val B = BigDecimal(b).setScale(18)
    val C = BigDecimal(c).setScale(18)
    println(A * B / C)
}