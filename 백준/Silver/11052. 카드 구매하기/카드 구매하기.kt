fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val cards = readLine().split(" ").map { it.toInt() }
    val dp = MutableList(n + 1) { 0 }
    dp[1] = cards[0]
    (2..n).forEach { i ->
        (0 until i / 2).forEach { j ->
            dp[i] = maxOf(dp[j] + dp[i - j], cards[i - 1], dp[i])
        }
        if (i % 2 == 0) {
            dp[i] = maxOf(dp[i / 2] * 2, dp[i])
        } else {
            dp[i] = maxOf(dp[i / 2] + dp[i / 2 + 1], dp[i])
        }
    }
    println(dp.last())
}