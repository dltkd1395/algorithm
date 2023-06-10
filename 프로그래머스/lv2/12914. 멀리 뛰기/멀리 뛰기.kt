class Solution {
    fun solution(n: Int): Long {
        
        val dp = MutableList(2001) {0L}
        dp[0] = 0L
        dp[1] = 1L
        dp[2] = 2L
        
        if (n<=2) {
            return dp[n]
        }
        
        for (i in 3..n) {
            dp[i] = (dp[i-1]+dp[i-2])%1234567
        }

        return dp[n]
    }
}