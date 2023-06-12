class Solution {
    fun solution(s: String): String {
        
        return s.lowercase()
                .split(" ")
                .map { str -> str.replaceFirstChar { it.uppercase() }}
                .joinToString(" ")
    }
}
