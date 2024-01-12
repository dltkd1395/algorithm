fun main() {
    while (true) {
        val (w, h) = readln().split(" ").map { it.toInt() }
        if (w == 0 && h == 0) break
        var landCnt = 0
        val map = List(h) { readln().split(" ").map { it.toInt() } }
        val visited = List(h) { MutableList(w) { 0 } }

        (0 until h).forEach { i ->
            (0 until w).forEach { j ->
                if (visited[i][j] == 0 && map[i][j] == 1) {
                    landCnt++
                    bfs(i, j, h, w, map, visited)
                }
            }
        }
        println(landCnt)
    }
}

data class Position(val x: Int, val y: Int)

val dx = listOf(1, 0, 0, -1, 1, 1, -1, -1)
val dy = listOf(0, 1, -1, 0, 1, -1, 1, -1)

fun bfs(
    i: Int,
    j: Int,
    h: Int,
    w: Int,
    map: List<List<Int>>,
    visited: List<MutableList<Int>>,
) {
    val deque = ArrayDeque<Position>()
    deque.add(Position(i, j))

    while (deque.isNotEmpty()) {
        val (x, y) = deque.removeFirst()
        (0 until 8).forEach { d ->
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx in (0 until h) && ny in (0 until w)) {
                if (visited[nx][ny] == 0 && map[nx][ny] == 1) {
                    visited[nx][ny] = 1
                    deque.add(Position(nx, ny))
                }
            }
        }
    }
}
