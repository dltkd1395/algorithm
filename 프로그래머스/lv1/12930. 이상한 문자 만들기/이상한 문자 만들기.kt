class Solution {
    fun solution(s: String): String {
        return s.split(" ")
            .map(String::toCharArray)
            .map { it.mapIndexed { i, c -> if (i%2 == 0) c.uppercase() else c.lowercase() }.joinToString("")}
            .joinToString(" ")
    }
}