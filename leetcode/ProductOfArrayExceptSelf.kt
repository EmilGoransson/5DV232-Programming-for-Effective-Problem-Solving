fun main() {
    fun productExceptSelf(nums: IntArray): IntArray {
        var pre = 1;
        val preArr = IntArray(nums.size)
        for (i in nums.indices) {
            pre *= nums[i]
            preArr[i] = pre
        }
        var post = 1;
        val postArr = IntArray(nums.size)
        for (i in nums.lastIndex downTo 0) {
            post *= nums[i]
            postArr[i] = post
        }
        val retArr = IntArray(nums.size)
        retArr[0] = postArr[1]
        retArr[nums.size - 1] = preArr[nums.size - 2]

        for (i in 1 until nums.size - 1) {
            retArr[i] = preArr[i - 1] * postArr[i + 1]
        }
        return retArr
    }
    println(productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).contentToString())

}