class Solution {
    fun solution(n: Int): Int {
        return n.toString()
            .map(Character::getNumericValue)
            .fold(0) { acc, v -> acc + v}
    }
}