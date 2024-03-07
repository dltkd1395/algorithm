fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val schedule = List(n) {
        readLine().split(" ").map { it.toInt() }
    }
    val dp = MutableList(n + 1) { 0 }
    (n - 1 downTo 0).forEach { index ->
        val (day, amount) = schedule[index]
        when {
            index + day > n -> {
                dp[index] = dp[index + 1]
            }
            index + day <= n -> {
                dp[index] = maxOf(dp[index + day] + amount, dp[index + 1])
            }
        }
    }
    println(dp[0])
}
