fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val dp = List(n + 1) { MutableList(n + 1) { 0 } }

    for (i in 1..n) {
        val line = readLine().split(" ").map { it.toInt() }
        for (j in 1..n) {
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + line[j - 1]
        }
    }

    repeat(m) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        println(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1])
    }
}