class Solution {
    
   
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        
        val sum = brown+yellow
        
        (3..sum).forEach {
            val j = sum/it
            
            if (sum % it == 0 && j >= 3) {
               val col = maxOf(it, j)
               val row = minOf(it, j)
               
               if ((col-2)*(row-2) == yellow) {
                   return intArrayOf(col, row)
               }
               
            }
        }
        
        return answer
    }
}