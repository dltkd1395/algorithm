class Solution {
    fun solution(n: Int): String {
        return (0 until n).mapIndexed { i, v -> if (i%2==0) "수" else "박" }
            .joinToString("")
    }
}