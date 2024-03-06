fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = MutableList(91) { 0L }
    dp[1] = 1L
    dp[2] = 1L

    (3..n).forEach { index ->
        dp[index] = dp[index - 2] + dp[index - 1]
    }
    println(dp[n])
}
