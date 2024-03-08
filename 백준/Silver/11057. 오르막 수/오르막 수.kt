fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = List(1001) { MutableList(10) { 0 } }
    (0..9).forEach { j ->
        dp[1][j] = 1
    }

    (2..n).forEach { i ->
        dp[i][0] = 1
        (1..9).forEach { j ->
            dp[i][j] = maxOf(dp[i - 1][j] + dp[i][j - 1]) % 10007
        }
    }
    println(dp[n].sum() % 10007)
}
