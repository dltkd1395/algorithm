import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map(String::toInt)

    val board = Array(n) { IntArray(m) }

    val dx = intArrayOf(1, 0, 0, -1)
    val dy = intArrayOf(0, 1, -1, 0)

    data class Point(val r: Int, val c: Int)
    val birus = mutableListOf<Point>()
    var answer = 0
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map(String::toInt)
        for (j in 0 until m) {
            board[i][j] = row[j]
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (board[i][j] == 2) {
                birus.add(Point(i, j))
            }
        }
    }

    fun bfs(tmp: Array<IntArray>) {
        val visited = Array(n) { BooleanArray(m) { false } }
        val q = ArrayDeque<Point>()
        birus.forEach {
            q.add(Point(it.r, it.c))
        }
        while (q.isNotEmpty()) {
            val (x, y) = q.removeFirst()

            for (d in 0 until 4) {
                val nx = dx[d] + x
                val ny = dy[d] + y

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && tmp[nx][ny] == 0) {
                        tmp[nx][ny] = 2
                        visited[nx][ny] = true
                        q.add(Point(nx,ny))
                    }
                }
            }
        }

        var cnt = 0
        tmp.forEach { cnt += it.count { it == 0 } }
        answer = maxOf(answer, cnt)
    }

    fun backtracking(tmp: Array<IntArray>, w: Int) {
        if (w == 3) {
            bfs(tmp)
            return
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (tmp[i][j] == 0) {
                    val copiedArray = tmp.map { it.copyOf() }.toTypedArray()
                    copiedArray[i][j] = 1
                    backtracking(copiedArray, w + 1)
                }
            }
        }
    }


    backtracking(board, 0)
    println(answer)
}