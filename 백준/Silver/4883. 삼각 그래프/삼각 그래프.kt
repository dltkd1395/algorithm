
fun main() = with(System.`in`.bufferedReader()) {
    val dp = List(100001) { MutableList(3) { 0 } }
    var num = 1
    while (true) {
        val n = readLine().toInt()
        if (n == 0) break
        (0 until n).forEach { i ->
            val (n1, n2, n3) = readLine().split(" ").map { it.toInt() }
            dp[i][0] = n1
            dp[i][1] = n2
            dp[i][2] = n3
        }
        dp[1][0] += dp[0][1]
        dp[1][1] += minOf(dp[1][0], minOf(dp[0][1], dp[0][1] + dp[0][2]))
        dp[1][2] += minOf(dp[1][1], minOf(dp[0][1], dp[0][1] + dp[0][2]))

        (2..n).forEach { i ->
            dp[i][0] += minOf(dp[i - 1][0], dp[i - 1][1])
            dp[i][1] += minOf(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2], dp[i][0])
            dp[i][2] += minOf(dp[i - 1][1], dp[i - 1][2], dp[i][1])
        }
        println("$num. ${dp[n - 1][1]}")
        num++
    }
}