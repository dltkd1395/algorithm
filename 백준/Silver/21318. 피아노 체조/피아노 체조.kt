fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val n = readLine().toInt()
    val arr = listOf(0) + readLine().split(" ").map { it.toInt() }
    val prefixSum = MutableList(n + 1) { 0 }
    for (i in 1 until n + 1) {
        if (arr[i - 1] > arr[i]) {
            prefixSum[i] = prefixSum[i - 1] + 1
        } else {
            prefixSum[i] = prefixSum[i - 1]
        }
    }
    repeat(readLine().toInt()) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        bw.write("${prefixSum[y] - prefixSum[x]}\n")
    }
    bw.close()
}
