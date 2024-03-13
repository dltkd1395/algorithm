fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val m = readLine().toInt()
    val prefixSum = MutableList(n + 1) { 0 }
    for (i in 1 until n + 1) {
        prefixSum[i] = prefixSum[i - 1] + arr[i - 1]
    }

    repeat(m) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        println(prefixSum[y] - prefixSum[x - 1])
    }
}
