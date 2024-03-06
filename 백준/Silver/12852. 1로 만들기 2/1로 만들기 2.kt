fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    val dp = MutableList(1000001) { it }
    dp[0] = 0
    dp[1] = 0
    dp[2] = 1
    dp[3] = 1

    (4..n).forEach { number ->
        if (number % 2 == 0) dp[number] = minOf(dp[number / 2], dp[number])
        if (number % 3 == 0) dp[number] = minOf(dp[number / 3], dp[number])
        dp[number] = minOf(dp[number - 1], dp[number]) + 1
    }
    println(dp[n])

    while(true) {
        print("$n ")
        if (n == 1) break
        when {
            dp[n] == dp[n - 1] + 1 -> n = n - 1
            n % 2 == 0 && dp[n] == dp[n / 2] + 1 -> n = n / 2
            n % 3 == 0 && dp[n] == dp[n / 3] + 1 -> n = n / 3
        }
    }
}
