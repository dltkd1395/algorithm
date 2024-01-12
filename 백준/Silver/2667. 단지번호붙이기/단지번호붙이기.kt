val dx = listOf(1, 0, 0, -1)
val dy = listOf(0, 1, -1, 0)

data class Position(val x: Int, val y: Int)

fun main() {
    val n = readln().toInt()
    val graph = List(n) {
        readln().split("").subList(1, n + 1).map { it.toInt() }
    }
    val visited = MutableList(n) {
        MutableList(n) { 0 }
    }
    var complex = 0
    val houses = mutableListOf<Int>()
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if (graph[i][j] == 1 && visited[i][j] == 0) {
                complex++
                visited[i][j] = 1
                houses.add(getHouseCount(n, i, j, graph, visited))
            }
        }
    }
    println(complex)
    houses.sorted().forEach { house ->
        println(house)
    }
}

fun getHouseCount(
    n: Int,
    i: Int,
    j: Int,
    graph: List<List<Int>>,
    visited: MutableList<MutableList<Int>>,
): Int {
    val deque = ArrayDeque<Position>().apply {
        add(Position(i, j))
    }
    var cnt = 1
    while (deque.isNotEmpty()) {
        val (x, y) = deque.removeFirst()
        (0 until 4).forEach { d ->
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx in (0 until n) && ny in (0 until n)) {
                if (visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                    visited[nx][ny] = 1
                    deque.add(Position(nx, ny))
                    cnt++
                }
            }
        }
    }
    return cnt
}