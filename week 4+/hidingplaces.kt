import java.lang.Exception

fun main() {
    val alph = "abcdefgh".toCharArray()
    fun getAnswer(colStrt: Int, rowStrt: Int) {
        fun createArray(): Array<Array<Int?>> {
            return Array(8) { Array(8) { null } }
        }

        val board = createArray()
        fun movesToSquares(
            col: Int,
            row: Int,
            count: Int
        ) {
            if (col < 0 || row < 0 || col > 7 || row > 7)
                return

            if (board[col][row] != null && count >= board[col][row]!!)
                return

            board[col][row] = count

            movesToSquares(col - 1, row + 2, count + 1)
            movesToSquares(col + 1, row + 2, count + 1)
            movesToSquares(col + 2, row + 1, count + 1)
            movesToSquares(col + 2, row - 1, count + 1)
            movesToSquares(col + 1, row - 2, count + 1)
            movesToSquares(col - 1, row - 2, count + 1)
            movesToSquares(col - 2, row - 1, count + 1)
            movesToSquares(col - 2, row + 1, count + 1)
        }

        movesToSquares(colStrt, rowStrt, 0)

        var max = 0;
        var lst = mutableListOf<Pair<Int, Int>>()
        for (row in 7 downTo 0) {
            for (col in 0 until 8) {
                if (board[col][row]!! > max) {
                    max = board[col][row]!!
                    lst = mutableListOf<Pair<Int, Int>>()
                    lst.add(Pair(col, row))
                } else if (board[col][row] == max)
                    lst.add(Pair(col, row))
            }
        }
        print("$max ")
        lst.forEach { i ->
            var (col, row) = i
            row += 1

            print(alph[col] + "$row ")

        }
        println()
    }

    var input = readLine()
    try {
        while (input != null) {
            input = readLine()
            val arr = input!!.split("")
            val col = arr[1].first()
            val row = arr[2].toInt()
            getAnswer(alph.indexOf(col), row - 1)
        }
    } catch (_: Exception) {

    }

}
