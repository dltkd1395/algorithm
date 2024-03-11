fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val grid = Array(n + 1) { CharArray(m + 1) }

    for (i in 1..n) {
        val line = readLine()
        for (j in 1..m) {
            grid[i][j] = line[j - 1]
        }
    }

    val dp = List(n + 1) { MutableList(m + 1) { 0 } }
    var maxLength = 0

    for (i in 1..n) {
        for (j in 1..m) {
            if (grid[i][j] == '1') {
                dp[i][j] = minOf(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
                maxLength = maxOf(maxLength, dp[i][j])
            }
        }
    }

    println(maxLength * maxLength)
}
