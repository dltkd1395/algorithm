class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        (1..citations.size).forEach { c ->
            val upCount = citations.filter { c <= it }.size
            val downCount = citations.size - upCount
            
            if (upCount >= c && downCount <= c) {
                answer = c
            }
            
        }
        return answer
    }
}