fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = MutableList(1001) { 0 }
    dp[1] = 1
    dp[2] = 3

    (3..n).forEach { index ->
        dp[index] = (dp[index - 2] * 2 + dp[index - 1]) % 10007
    }
    println(dp[n])
}
