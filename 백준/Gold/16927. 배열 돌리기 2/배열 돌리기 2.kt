fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    val matrix = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    fun rotate(s: Int, length: Int) {

        val cr = r % length

        repeat(cr) {
            val tmp = matrix[s][s]
            var d = 0
            var x = s
            var y = s

            while(d < 4) {
                val nx = dx[d] + x
                val ny = dy[d] + y

                if (nx in s until n - s && ny in s until m - s) {
                    matrix[x][y] = matrix[nx][ny]
                    x = nx
                    y = ny
                } else {
                    d++
                }
            }
            matrix[s + 1][s] = tmp
        }
    }
    var n1 = n
    var m1 = m
    repeat(minOf(n, m) / 2) { i ->
        rotate(i, 2 * n1 + 2 * m1 - 4)
        n1-=2
        m1-=2
    }
    matrix.forEach { println(it.joinToString(" ")) }
}
