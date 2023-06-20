fun main() {
    val alph = "abcdefghijklmnopqrstuvwxyz".toCharArray()
    fun getWordFromValue(value: Int): String {
        return alph[value - 1].toString()
    }

    val input = readLine();
    var len = input?.substringBefore(" ")!!.toInt()
    var wei = input.substringAfter(" ").toInt()
    var word = ""
    if (wei >= len * 26 + 1 || wei < len) {
        println("impossible")
    } else {
        while (true) {
            val roundedWeightAvg = (wei / len)
            val lastLetter = wei - roundedWeightAvg * (len - 1)
            if (lastLetter > 26) {
                word += "z"
                wei -= 26
                len--
            } else {
                val fill = getWordFromValue(roundedWeightAvg)
                for (i in 0 until len - 1) {
                    word += fill
                }
                word += getWordFromValue(lastLetter)
                break
            }
        }
        println(word)
    }
}