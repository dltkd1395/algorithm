fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val arr = List(n) { readLine().split(" ").map { it.toInt() } }
    val dp = MutableList(n + 1) { 0 }

    repeat(n) { i ->
        if (i + arr[i][0] <= n) {
            if (i > 0) {
                dp[i] = maxOf(dp[i], dp[i - 1])
            }
            dp[i + arr[i][0]] = maxOf(dp[i + arr[i][0]], dp[i] + arr[i][1])
        }
    }
    println(dp.max())
}
