import java.util.*
import kotlin.math.max

fun main() {
    val (h, c) = readLine()!!.split(" ").map { it.toInt() }
    var res: Long = 0
    val prioQueue = PriorityQueue<Pair<Long, Long>>(compareBy { it.first })

    repeat(c) {
        val (init, inc) = readLine()!!.split(" ").map { it.toLong() }
        res = max(res, init)
        prioQueue.add(Pair(init + inc, inc))
    }

    repeat(h) {

        val test = prioQueue.poll()
        val (init, inc) = test
        res = max(res, init)
        prioQueue.add(Pair(init + inc, inc))
    }
    println(res)
}
