fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = MutableList(n + 1) { it }
    (2..n).forEach { i ->
        (2..Math.sqrt(i.toDouble()).toInt()).forEach { j ->
            dp[i] = minOf(dp[i], dp[i - j * j] + 1)
        }
    }
    println(dp[n])
}