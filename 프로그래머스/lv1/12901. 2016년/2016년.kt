class Solution {
    
    val month = listOf(31,29,31,30,31,30,31,31,30,31,30,31)
    val week = listOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED")
    
    fun solution(a: Int, b: Int): String {
        
        return week[((0 until a-1).fold(0) { acc, m -> acc + month[m] } + b)%7]
    }
}