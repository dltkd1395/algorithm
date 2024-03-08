fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = MutableList(1000001) { 0 }
    dp[1] = 1
    dp[2] = 2

    (3..n).forEach { i ->
        dp[i] = (dp[i - 1] + dp[i - 2]) % 15746
    }
    println(dp[n])
}