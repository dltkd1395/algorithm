class Solution {
    fun solution(n: Int): Int {
        val dp = MutableList(1000001) { 0 }
        dp[0] = 0
        dp[1] = 1
        
        (2..n).forEach {
            dp[it] = (dp[it-1] + dp[it-2])%1234567
        }
        
        return dp[n]
    }
}