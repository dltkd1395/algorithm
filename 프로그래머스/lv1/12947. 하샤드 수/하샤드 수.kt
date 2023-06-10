class Solution {
    fun solution(x: Int): Boolean {
        
        return x.toString()
            .map { it.toString().toInt() }
            .sum()
            .takeIf { x % it == 0 } != null 
    }
}