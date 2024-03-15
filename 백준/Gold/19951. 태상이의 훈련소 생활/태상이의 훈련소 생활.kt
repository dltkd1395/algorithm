fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }
    val prefixSum = MutableList(n + 2) { 0 }

    repeat(m) {
        val (a, b, k) = readLine().split(" ").map { it.toInt() }
        prefixSum[a] += k
        prefixSum[b + 1] += -k
    }

    for (i in 1 until n + 1) {
        prefixSum[i] += prefixSum[i - 1]
        print("${prefixSum[i] + arr[i - 1]} ")
    }
}