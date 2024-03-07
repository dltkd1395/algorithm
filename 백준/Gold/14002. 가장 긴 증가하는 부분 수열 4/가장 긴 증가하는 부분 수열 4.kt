fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val numbers = readLine().split(" ").map { it.toInt() }
    val dp = MutableList(n) { 1 }

    (0 until n).forEach { i ->
        (0 until i).forEach { j ->
            if (numbers[i] > numbers[j]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }
    var cnt = dp.max()
    println(cnt)
    val result = mutableListOf<Int>()
    (n - 1 downTo 0).forEach { i ->
        if (dp[i] == cnt) {
            result.add(numbers[i])
            cnt--
        }
    }
    println(result.reversed().joinToString(" "))
}
