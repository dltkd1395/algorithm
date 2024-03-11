fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = MutableList(31) { 0 }
    dp[2] = 3
    (4..n step 2).forEach { i ->
        dp[i] = dp[i - 2] * dp[2]
        (i - 4 downTo 0 step 2).forEach { j ->
            dp[i] += dp[j] * 2
        }
        dp[i] += 2
    }
    println(dp[n])
}