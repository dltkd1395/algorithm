fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val sum = mutableListOf<Int>(arr[0])
    for (i in 1 until n) {
        sum.add(sum[i - 1] + arr[i])
    }
    var result = 0L
    for (i in 0 until n - 1) {
        result += arr[i] * (sum[n - 1] - sum[i])
    }
    println(result)
}
