fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = List(101) { MutableList(10) { 1L } }
    dp[1][0] = 0L
    val mod = 1000000000
    (2..n).forEach { x ->
        dp[x][0] = dp[x - 1][1] % mod
        (1..8).forEach { y ->
            dp[x][y] = dp[x - 1][y - 1] + dp[x - 1][y + 1] % mod
        }
        dp[x][9] = dp[x - 1][8] % mod
    }
    println(dp[n].sum() % mod)
}
