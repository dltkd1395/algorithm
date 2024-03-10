fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = MutableList(1001) { "" }
    dp[1] = "SK"
    dp[2] = "CY"
    dp[3] = "SK"
    dp[4] = "SK"
    dp[5] = "SK"
    (6..n).forEach { i ->
        listOf(1, 3, 4).forEach { num ->
            if (dp[i - num] == "CY") {
                dp[i] = "SK"
            }
        }
        if (dp[i] == "") dp[i] = "CY"
    }
    println(dp[n])
}