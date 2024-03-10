fun main() = with(System.`in`.bufferedReader()) {
    val tc = readLine().toInt()
    repeat(tc) {
        val n = readLine().toInt()
        val coins = readLine().split(" ").map { it.toInt() }
        val amount = readLine().toInt()
        val dp = List(n + 1) { MutableList(10001) { 0 } }
        dp[0][0] = 1
        (1..n).forEach { i ->
            (0 until coins[i - 1]).forEach { j ->
                dp[i][j] = dp[i - 1][j]
            }
            (coins[i - 1]..amount).forEach { j ->
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
            }
        }
        println(dp[n][amount])
    }
}
