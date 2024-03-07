fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = MutableList(91) { 0L }
    dp[1] = 1L

    (2..n).forEach { index ->
        dp[index] = dp[index - 1] + dp[index - 2]
    }
    println(dp[n])
}
