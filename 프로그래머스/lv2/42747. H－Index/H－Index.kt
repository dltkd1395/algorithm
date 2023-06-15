class Solution {
    fun solution(citations: IntArray): Int {
     
        return citations.sortedDescending()
            .mapIndexed { i, v -> minOf(i+1,v)}
            .maxOrNull() as Int
    }
}