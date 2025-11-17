package YandexList

import java.util.LinkedHashSet

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxSubstringLength = 0
        val currentString = LinkedHashSet<Char>()
        var currMaxLength = 0

        for (i in s.toCharArray()) {
            if (currentString.contains(i)) {
                maxSubstringLength = currMaxLength.coerceAtLeast(maxSubstringLength)
                for (c in currentString.toCharArray()) {
                    currentString.remove(c)
                    currMaxLength--
                    if (c == i) {
                        break
                    }
                }
            }
            currentString.add(i)
            currMaxLength++
        }

        return currMaxLength.coerceAtLeast(maxSubstringLength)


    }

}

fun main() {
    val longestSubstringClass: LongestSubstringWithoutRepeatingCharacters = LongestSubstringWithoutRepeatingCharacters()
    println(longestSubstringClass.lengthOfLongestSubstring(" "))
    println(longestSubstringClass.lengthOfLongestSubstring("dvdf"))
}