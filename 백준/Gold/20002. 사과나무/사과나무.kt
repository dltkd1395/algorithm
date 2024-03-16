fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val n = readLine().toInt()
    val pre = List(n + 1) { MutableList(n + 1) { -1001 } }

    for (i in 1..n) {
        val arr = readLine().split(" ").map { it.toInt() }
        for (j in 1..n) {
            pre[i][j] = pre[i][j - 1] + pre[i - 1][j] - pre[i - 1][j - 1] + arr[j - 1]
        }
    }

    var maxProfit = pre[0][0]
    for (k in 0 until n) {
        for (i in 1..n - k) {
            for (j in 1..n - k) {
                val profit = pre[i + k][j + k] - pre[i - 1][j + k] - pre[i + k][j - 1] + pre[i - 1][j - 1]
                maxProfit = maxOf(maxProfit, profit)
            }
        }
    }

    bw.use { it.write("$maxProfit") }
}