var maxSize = 0
var painterCount = 0

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = List(n) {
        readln().split(" ").map { it.toInt() }
    }
    val visited = MutableList(n) {
        MutableList(m) { 0 }
    }
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (graph[i][j] == 1 && visited[i][j] == 0) {
                painterCount++
                visited[i][j] = 1
                bfs(n, m, i, j, graph, visited)
            }
        }
    }
    println("$painterCount\n$maxSize")
}

val dx = listOf(1, 0, 0, -1)
val dy = listOf(0, 1, -1, 0)

data class Position(val x: Int, val y: Int)

fun bfs(
    n: Int,
    m: Int,
    i: Int,
    j: Int,
    graph: List<List<Int>>,
    visited: MutableList<MutableList<Int>>,
) {
    val deque = ArrayDeque<Position>()
    deque.add(Position(i, j))
    var cnt = 1
    while (deque.isNotEmpty()) {
        val (x, y) = deque.removeFirst()
        (0 until 4).forEach { i ->
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in (0 until n) && ny in (0 until m)) {
                if (visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                    visited[nx][ny] = 1
                    cnt++
                    deque.add(Position(nx, ny))
                }
            }
        }
    }
    maxSize = maxOf(maxSize, cnt)
}
