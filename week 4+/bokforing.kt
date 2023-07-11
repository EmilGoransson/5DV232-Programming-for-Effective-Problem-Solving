fun main() {
    val (_, q) = readLine()!!.split(' ').map(String::toInt)
    var vals = hashMapOf<Int, Int>()
    var def = 0

    repeat(q) {
        val inp = readLine()!!.split(' ')
        val op = inp[0]
        when (op) {
            "SET" -> {
                vals[inp[1].toInt()] = inp[2].toInt()
            }

            "PRINT" ->
                println(vals.getOrDefault(inp[1].toInt(), def))


            else -> {
                def = inp[1].toInt()
                vals = hashMapOf<Int, Int>()
            }
        }
    }
}