fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val dp = MutableList(n + 1) { 0 }
    dp[0] = 1
    dp[1] = 1
    (2..n).forEach { i ->
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    var result = 1
    var tmp = 0
    repeat(m) {
        val seat = readLine().toInt()
        result *= dp[seat - tmp - 1]
        tmp = seat
    }
    result *= dp[n - tmp]
    println(result)
}