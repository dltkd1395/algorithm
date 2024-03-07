fun main() = with(System.`in`.bufferedReader()) {
    val (t, w) = readLine().split(" ").map { it.toInt() }
    val dp = List(t + 1) { MutableList(w + 1) { 0 } }
    val trees = listOf(0) + List(t) { readLine().toInt() }

    (1..t).forEach { i ->
        if (trees[i] == 1) {
            dp[i][0] = dp[i - 1][0] + 1
        } else {
            dp[i][0] = dp[i - 1][0]
        }
        (1..w).forEach { j ->
            when {
                j % 2 == 0 && trees[i] == 1 -> {
                    dp[i][j] = maxOf(dp[i - 1][j - 1], dp[i - 1][j]) + 1
                }

                j % 2 == 1 && trees[i] == 2 -> {
                    dp[i][j] = maxOf(dp[i - 1][j - 1], dp[i - 1][j]) + 1
                }

                else -> {
                    dp[i][j] = maxOf(dp[i - 1][j - 1], dp[i - 1][j])
                }
            }
        }
    }
    println(dp.last().max())
}
