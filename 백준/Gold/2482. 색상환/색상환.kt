const val MOD = 1000000003
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val k = readLine().toInt()
    val dp = List(k + 1) { MutableList(n + 1) { 0 } }
    for (i in 1..n) {
        dp[1][i] = i
    }

    for (i in 2..k) {
        for (j in i + 2..n) {
            dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 2]) % MOD
        }
    }
    println(dp[k][n])
}
