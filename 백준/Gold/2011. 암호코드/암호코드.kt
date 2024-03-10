const val MOD = 1000000
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()
    val l = n.length
    val dp = MutableList(l + 1) { 0 }
    dp[0] = 1
    dp[1] = 1
    if (n[0] == '0') {
        println(0)
    } else {
        (2 until dp.size).forEach { i ->
            if (n[i - 1] == '0') {
                if (n.substring(i - 2, i).toInt() in 1..26) {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD
                }
            } else {
                dp[i] = dp[i - 1] % MOD
                if (n.substring(i - 2, i).toInt() in 11..26) {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD
                }
            }
        }
        println(dp[l])
    }
}
