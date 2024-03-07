fun main() {
    val n = readln().toInt()
    val numbers = readlnOrNull()?.split(" ")?.map { it.toInt() } ?: return
    val dp = MutableList(n) { 1 }
    var result = 0
    (0 until n).forEach { x ->
        (0 until x).forEach { y ->
            if (numbers[x] > numbers[y]) {
                dp[x] = maxOf(dp[x], dp[y] + 1)
            }
        }
    }
    println(dp.max())
}