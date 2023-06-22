fun main() {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (!map.containsKey(nums[i])) {
                map[nums[i]] = 1
            } else {
                map[nums[i]] = map[nums[i]]!! + 1

            }
        }
        val sorted = map.toList()
            .sortedByDescending { (_, value) -> value }

        val retArr = IntArray(k)
        for (i in 0 until k) {
            var (key, _) = sorted[i]
            retArr[i] = key
        }
        return retArr
    }
    println(topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).contentToString())
}