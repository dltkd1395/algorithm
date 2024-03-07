fun main() = with(System.`in`.bufferedReader()) {
    val tc = readLine().toInt()
    val dp = MutableList(1000001) { 0L }
    dp[1] = 1L
    dp[2] = 2L
    dp[3] = 4L
    (4..1000000).forEach { i ->
        dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009
    }
    repeat(tc) {
        val n = readLine().toInt()
        println(dp[n])
    }
}
