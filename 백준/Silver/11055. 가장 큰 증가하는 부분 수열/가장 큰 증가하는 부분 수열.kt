fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val numbers = readLine().split(" ").map { it.toInt() }
    val dp = MutableList(n) { numbers[it] }
    for (i in 0 until n) {
        for (j in 0 until i + 1) {
            if (numbers[i] > numbers[j]) {
                dp[i] = maxOf(dp[i], dp[j] + numbers[i])
            }
        }
    }
    println(dp.max())
}
