fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val glasses = List(n) { readLine().toInt() }
    val dp = MutableList(10001) { 0 }
    dp[0] = glasses[0]
    if (n > 1) dp[1] = dp[0] + glasses[1]
    if (n > 2) dp[2] = maxOf(glasses[2] + glasses[1], glasses[2] + glasses[0], dp[1])
    (3 until n).forEach { i ->
        dp[i] = maxOf(dp[i - 2] + glasses[i], dp[i - 3] + glasses[i - 1] + glasses[i], dp[i - 1])
    }
    println(dp.max())
}