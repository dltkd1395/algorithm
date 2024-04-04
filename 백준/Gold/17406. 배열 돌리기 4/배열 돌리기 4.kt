fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val matrix = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val operation = Array(k) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun rotate(sx: Int, sy: Int, ex: Int, ey: Int, arr: Array<IntArray>): Array<IntArray> {
        val nl = ex - sx + 1
        val ml = ey - sy + 1
        var x = sx
        var y = sy
        var d = 0
        val tmp = arr[sx][sy]
        while (d < 4) {
            val nx = dx[d] + x
            val ny = dy[d] + y
            if (nx in sx until sx + nl && ny in sy until sy + ml) {
                arr[x][y] = arr[nx][ny]
                x = nx
                y = ny
            } else {
                d++
            }
        }
        arr[sx][sy + 1] = tmp
        return arr
    }

    var minValue = Int.MAX_VALUE
    val visited = BooleanArray(k)
    fun findMinValue(cnt: Int, op: MutableList<IntArray>) {
        if (cnt == k) {
            var tmp = Array(n) { i ->
                IntArray(m) { j ->
                    matrix[i][j]
                }
            }
            for (i in 0 until k) {
                val (r, c, s) = op[i]
                var sx = r - s - 1
                var sy = c - s - 1
                var ex = r + s - 1
                var ey = c + s - 1
                val nl = ex - sx + 1
                val ml = ey - sy + 1
                for (i in 0 until minOf(nl, ml) / 2) {
                    tmp = rotate(sx, sy, ex, ey, tmp)
                    sx += 1
                    sy += 1
                    ex -= 1
                    ey -= 1
                }
            }
            tmp.forEach { minValue = minOf(minValue, it.sum()) }
            return
        }

        for (i in 0 until k) {
            if (visited[i].not()) {
                visited[i] = true
                op.add(operation[i])
                findMinValue(cnt + 1, op)
                op.removeLast()
                visited[i] = false
            }
        }
    }
    findMinValue(0, mutableListOf())
    println(minValue)
}
