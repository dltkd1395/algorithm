fun main() = with(System.`in`.bufferedReader()) {
    val str1 = readLine()
    val str2 = readLine()
    val n = str2.length
    val m = str1.length
    val dp = List(1001) { MutableList(1001) { 0 } }
    (1..n).forEach { i ->
        (1..m).forEach { j ->
            if (str1[j - 1] == str2[i - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    println(dp[n][m])
}