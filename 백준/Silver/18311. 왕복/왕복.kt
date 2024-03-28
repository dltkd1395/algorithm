fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toLong() }
    val arr = readLine().split(" ").map { it.toInt() }
    val total = arr.subList(0, n.toInt()) + arr.subList(0, n.toInt()).reversed()
    val prefixSum = LongArray(total.size + 1) // IntArray를 LongArray로 변경

    for (i in 1 until prefixSum.size) {
        prefixSum[i] = prefixSum[i - 1] + total[i - 1]

        if (k in prefixSum[i - 1] until prefixSum[i]) {
            val index = i.toLong()
            if (n < index) {
                println(n * 2 - index + 1)
            } else {
                println(index)
            }
        }
    }
}

