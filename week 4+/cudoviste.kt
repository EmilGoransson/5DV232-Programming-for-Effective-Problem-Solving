fun main() {
    val input = readLine()!!.split(" ").map(String::toInt)
    val y = input[0]
    val x = input[1]

    val arr: Array<Array<String>> = Array(y) { Array(x) { "" } }
    for (i in 0 until y) {
        arr[i] = readLine()!!.split("").filter { it.isNotBlank() }.toTypedArray()
    }

    fun check2x2(arr: Array<Array<String>>, x: Int, y: Int): Int {
        if (y + 1 >= arr.size || x + 1 >= arr[y].size)
            return -1
        val a = arr[y][x]
        val b = arr[y][x + 1]
        val c = arr[y + 1][x]
        val d = arr[y + 1][x + 1]

        if (a == "#" || b == "#" || c == "#" || d == "#")
            return -1

        var countCars = 0
        if (a == "X") countCars++
        if (b == "X") countCars++
        if (c == "X") countCars++
        if (d == "X") countCars++

        return countCars
    }

    val parkSpots = IntArray(5)

    for (i in 0 until y - 1) {
        for (j in 0 until x - 1) {
            val checkSquare = check2x2(arr, j, i)
            if (checkSquare in 0..4) {
                parkSpots[checkSquare]++
            }
        }
    }

    for (count in parkSpots) {
        println(count)
    }
}
