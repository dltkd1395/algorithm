class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = -1
        
         fun isPrime(num: Long): Boolean {
            if (num < 2L) return false
            var i = 2L
            while (i*i <= num) {
                if (num%i++ == 0L) return false 
            }
            return true
        }
      
        return n.toString(k)
            .split("0")
            .filter { it.isNotEmpty() }
            .map(String::toLongOrNull)
            .filterNotNull()
            .filter(::isPrime)
            .size
            
    }
    
   
}