fun main() = with(System.`in`.bufferedReader()) {
    val tc = readLine().toInt()
    repeat(tc) {
        val n = readLine().toInt()
        val l1 = listOf(0L) + readLine().split(" ").map { it.toLong() }
        val l2 = listOf(0L) + readLine().split(" ").map { it.toLong() }
        val dp = List(2) { MutableList(100001) { 0L } }
        dp[0][1] = l1[1]
        dp[1][1] = l2[1]
        (2..n).forEach { i ->
            dp[0][i] = maxOf(dp[1][i - 2] + l1[i], dp[1][i - 1] + l1[i])
            dp[1][i] = maxOf(dp[0][i - 2] + l2[i], dp[0][i - 1] + l2[i])
        }
        println(maxOf(dp[0][n], dp[1][n]))
    }
}