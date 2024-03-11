fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val numbers = readLine().split(" ").map { it.toInt() }
    val m = readLine().toInt()
    val dp = List(n) { MutableList(n) { 0 } }
    (0 until n).forEach { i ->
        dp[i][i] = 1
    }

    (0 until n - 1).forEach { i ->
        if (numbers[i] == numbers[i + 1]) {
            dp[i][i + 1] = 1
        }
    }

    (2 until n).forEach { cnt ->
        (0 until n - cnt).forEach { i ->
            val j = i + cnt
            if (numbers[i] == numbers[j] && dp[i + 1][j - 1] == 1) {
                dp[i][j] = 1
            }
        }
    }

    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()
    repeat(m) {
        val (x, y) = readLine().split(" ").map { it.toInt() - 1 }
        sb.appendLine(dp[x][y])
    }
    with(bw) {
        write(sb.toString())
        flush()
        close()
    }
}