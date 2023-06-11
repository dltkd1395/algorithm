class Solution {
    fun solution(s: String): String {
        return s.split(" ")
            .map(String::toInt)
            .sorted()
            .let { listOf(it.first(), it.last())}
            .joinToString(" ")
    }
}