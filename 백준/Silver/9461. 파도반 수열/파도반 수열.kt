fun main() = with(System.`in`.bufferedReader()) {
    val tc = readLine().toInt()
    val dp = MutableList(101) { 0L }
    dp[0] = 0L
    dp[1] = 1L
    dp[1] = 1L
    dp[2] = 1L
    repeat(tc) {
        val n = readLine().toInt()

        (3..n).forEach { index ->
            dp[index] = dp[index - 2] + dp[index- 3]
        }
        println(dp[n])
    }
}