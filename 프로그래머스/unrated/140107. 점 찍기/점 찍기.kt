class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0
        
        for (i in 0..d step k) {
            val y = Math.sqrt(Math.pow(d.toDouble(),2.0)-Math.pow(i.toDouble(),2.0))
            answer+=(Math.floor(y/k)+1).toLong()
        }
        
        return answer
    }
}