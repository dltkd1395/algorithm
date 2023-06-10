class Solution {
    fun solution(num: Int): Int {
        var answer = 0
        
        if (num == 1) return 0
        
        var n = num.toLong()
     
        do {
            if (answer == 500) return -1
            when {
                n%2==0L -> n/=2
                else -> n = n*3+1
            }
            answer++
        } while(n!=1L)
        
        return answer
    }
}