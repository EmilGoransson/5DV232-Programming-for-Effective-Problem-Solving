import kotlin.math.pow

fun main(args: Array<String>) {
    fun getSize(height: Long): Long {
        return (2.0.pow(height.toInt() + 1) - 1).toLong()
    }

    fun getDirections(input: Array<String>): Array<String> {
        return input[1].split("").filter { it.isNotBlank() }.toTypedArray()
    }

    var input = readLine();
    var arr = input!!.split(" ").filter { it.isNotBlank() }.toTypedArray()
    var height = arr[0].toLong()
    var directions = arrayOf<String>("")
    if (arr.size > 1) {
        directions = getDirections(arr)
    }
    if (arr.size == 1) {
        println(getSize(height))
    } else {
        var key: Long = 0;
        directions.forEach { i ->
            run {
                if (i == "L") {
                    key = (2 * key) + 1
                } else if (i == "R") {
                    key = (2 * key) + 2
                }
            }
        }
        println(getSize(height) - key)
    }


}

