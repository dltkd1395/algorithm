class Solution {
    fun solution(n: Long): Long {
        val sqrt = Math.sqrt(n.toDouble())
        return if (sqrt == sqrt.toLong().toDouble()) {
            val nextInt = sqrt.toLong() + 1
            nextInt * nextInt
        } else {
            -1L
        }
    }
}