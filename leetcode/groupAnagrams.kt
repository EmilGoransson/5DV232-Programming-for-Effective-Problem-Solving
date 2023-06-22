fun main() {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        for (i in strs) {
            val sortedStr = i.toCharArray().sorted().joinToString("")
            if (!map.containsKey(sortedStr)) {
                map[sortedStr] = mutableListOf()
            }
            map[sortedStr]?.add(i)
        }
        return map.values.toList()
    }
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}