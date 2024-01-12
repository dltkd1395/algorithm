val dx = listOf(1, 0, 0, -1)
val dy = listOf(0, 1, -1, 0)

data class Position(val x: Int, val y: Int)

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val box = List(n) {
        readln().split(" ").map { it.toInt() }
    }
    val tomato = ArrayDeque<Position>()
    val visited = MutableList(n) { MutableList(m) { -1 } }
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            when (box[i][j]) {
                1 -> {
                    tomato.add(Position(i, j))
                    visited[i][j] = 0
                }
            }
        }
    }

    bfs(tomato, n, m, visited, box)
    if (isRipenAllTomato(n, m, visited, box)) {
        println(visited.flatten().maxOrNull())
    } else {
        println(-1)
    }
}

private fun bfs(
    tomato: ArrayDeque<Position>,
    n: Int,
    m: Int,
    visited: MutableList<MutableList<Int>>,
    box: List<List<Int>>,
) {
    while (tomato.isNotEmpty()) {
        val (x, y) = tomato.removeFirst()
        (0 until 4).forEach { d ->
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx in (0 until n) && ny in (0 until m)) {
                if (visited[nx][ny] == -1 && box[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1
                    tomato.add(Position(nx, ny))
                }
            }
        }
    }
}

fun isRipenAllTomato(
    n: Int,
    m: Int,
    visited: MutableList<MutableList<Int>>,
    box: List<List<Int>>,
): Boolean {
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (visited[i][j] == -1 && box[i][j] == 0) {
                return false
            }
        }
    }
    return true
}