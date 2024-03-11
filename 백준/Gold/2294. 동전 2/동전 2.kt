fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val coins = List(n) { readLine().toInt() }
    val dp = MutableList(10001) { 10001 }
    dp[0] = 0
    (1..n).forEach { i ->
        (coins[i - 1]..k).forEach { j ->
            dp[j] = minOf(dp[j], dp[j - coins[i - 1]] + 1)
        }
    }
    println(if (dp[k] == 10001) -1 else dp[k])
}