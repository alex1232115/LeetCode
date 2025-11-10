package YandexList

class FindAllAnagramsInaString {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (p.length > s.length) return emptyList()

        val result: MutableList<Int> = mutableListOf()
        val pCount: HashMap<Char, Int> = hashMapOf()
        val sCount: HashMap<Char, Int> = hashMapOf()
        for (i in p.indices) {
            pCount[p[i]] = pCount.getOrDefault(p[i], 0) + 1
            sCount[s[i]] = sCount.getOrDefault(s[i], 0) + 1
        }
        var lastIndex = 0
        if (pCount == sCount) result.add(lastIndex)
        for (i in p.length until s.length){
            sCount[s[i]] = sCount.getOrDefault(s[i], 0) + 1
            sCount.computeIfPresent(s[lastIndex]) { _, value ->
                if (value == 1) null else value - 1
            }
            lastIndex += 1
            if (pCount == sCount) result.add(lastIndex)
        }
        return result
    }
}

fun main() {
    val solution = FindAllAnagramsInaString()
    println(solution.findAnagrams("cbaebabacd", "abc")) // [0, 6]
    println(solution.findAnagrams("abab", "ab")) // [0, 1, 2]
}