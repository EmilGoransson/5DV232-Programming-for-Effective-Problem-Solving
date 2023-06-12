fun main(args: Array<String>) {
    var startX = 0;
    var startY = 0;
    fun createArray(width: Int, height: Int): Array<Array<String>> {
        return (Array(height) { Array(width) { "#" } })
    }

    fun populateArray(arr: Array<Array<String>>): Array<Array<String>> {
        var line = readLine()
        var indx = 0;
        while (indx < arr.size - 1) {
            line = readLine()
            indx++
            val readArr = line!!.split("").filter { it.isNotBlank() }.toTypedArray()
            for (i in arr[indx].indices) {
                if (readArr[i] == "P") {
                    startX = indx
                    startY = i
                }
                arr[indx][i] = readArr[i]
            }
        }
        return arr
    }

    fun createMap(): Array<Array<String>> {
        val input = readLine()!!.split(" ").toTypedArray()
        return populateArray(createArray(input[0].toInt(), input[1].toInt()))
    }

    fun adjSafe(map: Array<Array<String>>, x: Int, y: Int): Boolean {
        val adjacentPositions = arrayOf(
            Pair(x, y + 1),  // Down
            Pair(x, y - 1),  // Up
            Pair(x + 1, y),  // Right
            Pair(x - 1, y)   // Left
        )
        for ((adjX, adjY) in adjacentPositions) {
            if (map[adjY][adjX] in setOf("T")) {
                return false
            }
        }
        return true
    }

    val visitedGoldNode: MutableSet<Pair<Int, Int>> = mutableSetOf()
    var goldCount = 0;
    fun maxGoldRec(map: Array<Array<String>>, visitedNodes: MutableSet<Pair<Int, Int>>, col: Int, row: Int, gold: Int) {
        var countGold = gold
        var visNodes = visitedNodes
        val curPos = Pair(col, row)

        if (visitedNodes.contains(curPos)) {
            return
        }
        if (row < 0 || row >= map[0].size || col < 0 || col >= map.size) return;

        if (map[col][row] == "G" && !visitedGoldNode.contains(curPos)) {
            visitedGoldNode.add(curPos)
            goldCount++
        }
        if (map[col][row] == "#") return;
        if (!adjSafe(map, row, col)) {
            return
        }
        visNodes.add(curPos)
        maxGoldRec(map, visNodes, col - 1, row, countGold)
        maxGoldRec(map, visNodes, col + 1, row, countGold)
        maxGoldRec(map, visNodes, col, row - 1, countGold)
        maxGoldRec(map, visNodes, col, row + 1, countGold)

    }
    maxGoldRec(createMap(), mutableSetOf(), startX, startY, 0)
    println(goldCount)
}
