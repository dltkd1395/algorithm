import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map(String::toInt)

    var (r, c, d) = br.readLine().split(" ").map(String::toInt)

    val board = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val row = br.readLine().split(" ").map(String::toInt)
        for (j in 0 until m) {
            board[i][j] = row[j]
        }
    }

    fun check(row: Int, col: Int): Boolean {
        for (i in 0 until 4) {
            val nx = row + dx[i]
            val ny = col + dy[i]

            if (board[nx][ny] == 0) {
                return true
            }
        }
        return false
    }

    var cnt = 0
    while (true) {
        if (board[r][c] == 0) {
            board[r][c] = -1
            cnt += 1
        }

        if (!check(r, c)) {
            val nx = r + dx[(d + 2) % 4]
            val ny = c + dy[(d + 2) % 4]

            if (board[nx][ny] == 1) {
                break
            }
            r = nx
            c = ny
        } else {
            d = if (d - 1 == -1) 3 else d - 1
  
            val nx = r + dx[d]
            val ny = c + dy[d]

            if (board[nx][ny] == 0) {
                r = nx
                c = ny
            }
        }
    }
    println(cnt)
}