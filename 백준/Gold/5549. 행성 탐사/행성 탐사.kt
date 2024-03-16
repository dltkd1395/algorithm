fun main() = with(System.`in`.bufferedReader()) {
    data class Area(val jungle: Int, val ocean: Int, val ice: Int)

    val bw = System.out.bufferedWriter()
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val k = readLine().toInt()
    val prefixSum = List(n + 1) { MutableList(m + 1) { Area(0, 0, 0) } }
    val area = List(n) { readLine() }

    for (i in 1 until n + 1) {
        for (j in 1 until m + 1) {
            var (j1, o1, i1) = prefixSum[i][j - 1]
            var (j2, o2, i2) = prefixSum[i - 1][j]
            var (j3, o3, i3) = prefixSum[i - 1][j - 1]

            val area1 = when (area[i - 1][j - 1]) {
                'J' -> prefixSum[i][j].copy(j1 + j2 - j3 + 1, o1 + o2 - o3, i1 + i2 - i3)
                'O' -> prefixSum[i][j].copy(j1 + j2 - j3, o1 + o2 - o3 + 1, i1 + i2 - i3)
                else -> prefixSum[i][j].copy(j1 + j2 - j3, o1 + o2 - o3, i1 + i2 - i3 + 1)
            }

            prefixSum[i][j] = area1
        }
    }

    repeat(k) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        val (j1, o1, i1) = prefixSum[x2][y2]
        val (j2, o2, i2) = prefixSum[x1 - 1][y2]
        val (j3, o3, i3) = prefixSum[x2][y1 - 1]
        val (j4, o4, i4) = prefixSum[x1 - 1][y1 - 1]
        val jungle = j1 - j2 - j3 + j4
        val ocean = o1 - o2 - o3 + o4
        val ice = i1 - i2 - i3 + i4
        bw.write("$jungle $ocean $ice\n")
    }
    bw.flush()
    bw.close()
}
