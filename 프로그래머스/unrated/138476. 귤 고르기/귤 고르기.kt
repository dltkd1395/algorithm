class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        
        val counter = tangerine.toList().groupingBy { it }.eachCount().map { it.key to it.value }.sortedByDescending { it.second }
        
        var cnt = 0
        for ((x,y) in counter) {
            answer++
            
            if (cnt + y >= k) {
                break
            }
            cnt+=y
        }
        
        return answer
    }
}