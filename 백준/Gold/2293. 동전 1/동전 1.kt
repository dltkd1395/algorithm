fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val coins = listOf(0) + List(n) { readLine().toInt() }
    val dp = MutableList(10001) { 0 }
    dp[0] = 1
    (1..n).forEach { i ->
        (coins[i]..k).forEach { j ->
            dp[j] += dp[j - coins[i]]
        }
    }
    println(dp[k])
}