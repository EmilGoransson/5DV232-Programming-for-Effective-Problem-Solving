fun main() {
    val (nRow, mCol) = readLine()!!.split(' ').map { it.toInt() }
    val arr: Array<IntArray> = Array(nRow) { IntArray(mCol) { 0 } }
    for (i in 0 until nRow) {
        arr[i] = readLine()!!.split("").filter { it.isNotBlank() }.map { it.toInt() }.toIntArray()
    }
    val visited: Array<BooleanArray> = Array(nRow) { BooleanArray(mCol) { false } }

    val endPoint = Pair(nRow - 1, mCol - 1)

    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    queue.add(Triple(0, 0, 0))

    var foundPath = false

    while (queue.isNotEmpty()) {
        val (row, col, count) = queue.removeFirst()

        if (row >= nRow || row < 0 || col >= mCol || col < 0)
            continue
        if (visited[row][col])
            continue
        if (Pair(row, col) == endPoint) {
            println(count)
            foundPath = true
            break
        }


        val moveAmount = arr[row][col]
        visited[row][col] = true

        queue.add(Triple(row + moveAmount, col, count + 1))
        queue.add(Triple(row - moveAmount, col, count + 1))
        queue.add(Triple(row, col + moveAmount, count + 1))
        queue.add(Triple(row, col - moveAmount, count + 1))
    }

    if (!foundPath) {
        println(-1)
    }
}
