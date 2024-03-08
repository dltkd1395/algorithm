fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = MutableList(1000001) { 0L }
    dp[1] = 1L

    (2..Math.abs(n)).forEach { i ->
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000
    }
    when {
        n % 2 == 0 && n < 0 -> println(-1)
        n == 0 -> println(0)
        else -> println(1)
    }
    println(dp[Math.abs(n)])
}