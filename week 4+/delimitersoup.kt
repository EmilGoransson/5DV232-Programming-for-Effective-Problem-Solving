import kotlin.Exception

fun main() {
    val stack = ArrayDeque<Char>();
    val l = readLine()!!.toInt()
    val seq = readLine()!!.toCharArray()
    var hasWritten = false;
    for (i in 0 until l) {
        val char = seq[i]
        if (char == ' ') continue;
        if (char == '(' || char == '{' || char == '[') {
            stack.addLast(char)
        } else {
            try {
                if (char == '}') {
                    if (stack.removeLast() != '{') {
                        println("$char $i")
                        hasWritten = true
                        return
                    }
                }
                if (char == ')') {
                    if (stack.removeLast() != '(') {
                        println("$char $i")
                        hasWritten = true
                        return
                    }
                }
                if (char == ']') {
                    if (stack.removeLast() != '[') {
                        println("$char $i")
                        hasWritten = true
                        return
                    }
                }
            } catch (e: Exception) {
                println("$char $i")
                hasWritten = true
            }
        }

    }
    if (!hasWritten) {
        println("ok so far")
    }
}
