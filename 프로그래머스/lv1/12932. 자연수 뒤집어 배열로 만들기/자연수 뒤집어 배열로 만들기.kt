class Solution {
    fun solution(n: Long): IntArray {
        return n.toString()
            .map(Character::getNumericValue)
            .reversed()
            .toIntArray()
    }
}