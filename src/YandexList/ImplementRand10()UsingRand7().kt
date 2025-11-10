package YandexList

import kotlin.random.Random

open class SolBase {
    fun rand7(): Int {
        return Random.nextInt(1, 8)
    }
}

/**
 * The rand7() API is already defined in the parent class SolBase.
 * fun rand7(): Int {}
 * @return a random integer in the range 1 to 7
 */
class Solution : SolBase() {
    fun rand10(): Int {
        var rand = (rand7() - 1) * 7 + rand7()
        while (rand > 40) {
            rand = (rand7() - 1) * 7 + rand7()
        }
        return (rand - 1) % 10 + 1
    }
}