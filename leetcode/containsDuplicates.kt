fun main() {

    fun containsDuplicate(nums: ArrayList<Int>): Boolean {

        val sorted = nums.sorted()
        for (i in sorted.indices) {
            println(sorted.size)

            if (i + 1 == sorted.size)
                return false
            if (sorted[i] == sorted[i + 1])
                return true;
        }
        println("test")

        return false


    }
    println(containsDuplicate(arrayListOf<Int>(1, 2, 3, 4)))
}

