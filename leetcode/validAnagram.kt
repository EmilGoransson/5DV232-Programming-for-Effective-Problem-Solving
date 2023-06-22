fun main() {
    fun isAnagram(s: String, t: String): Boolean {
        var subArray = s.toCharArray().sorted()
        var tArray = t.toCharArray().sorted()
        if (s.length != t.length)
            return false
        if (subArray == tArray)
            return true
        return false


    }
    println(isAnagram("rat", "cat"))
}