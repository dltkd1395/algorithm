fun main() = with(System.`in`.bufferedReader()) {
    val(n, q) = readLine().split(" ").map { it.toInt() }
    val a = readLine().split(" ").map { it.toInt() }.toIntArray()
    val prefixSum = MutableList(n) { 0 }

    for (i in 0 until n) {
        prefixSum[i] = a[i] * a[(i - 1 + n) % n] * a[(i - 2 + n) % n] * a[(i - 3 + n) % n]
    }

    val qs = readLine().split(" ").map { it.toInt() }
    var exSum = prefixSum.sum()

    for (idx in qs) {
        for (i in 0 until 4) {
            val newIdx = (idx - 1 + i + n) % n
            prefixSum[newIdx] = -prefixSum[newIdx]
            exSum += 2 * prefixSum[newIdx]
        }
        println(exSum)
    }
}