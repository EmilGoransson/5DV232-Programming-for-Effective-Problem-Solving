fun main() {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in nums.indices)
                if (i != j && nums[i] + nums[j] == target)
                    return intArrayOf(i, j)
        }
        return intArrayOf(0)
    }
    println(twoSum(intArrayOf(3, 2, 4), 6).toString())
}