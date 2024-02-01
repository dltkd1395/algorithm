import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val board = List(n) { readLine().split("").subList(1, n + 1).toMutableList() }

    var maxCandy = 0

    fun check(): Int {
        var count = 1
        for (i in 0 until n) {
            var temp = 1
            for (j in 1 until n) {
                if (board[i][j] == board[i][j - 1]) {
                    temp++
                } else {
                    temp = 1
                }
                count = maxOf(count, temp)
            }

            temp = 1
            for (j in 1 until n) {
                if (board[j][i] == board[j - 1][i]) {
                    temp++
                } else {
                    temp = 1
                }
                count = maxOf(count, temp)
            }
        }
        return count
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
      
            if (j < n - 1) {
                board[i][j] = board[i][j + 1].also { board[i][j + 1] = board[i][j] }
                maxCandy = maxOf(maxCandy, check())
                board[i][j] = board[i][j + 1].also { board[i][j + 1] = board[i][j] }
            }

            if (i < n - 1) {
                board[i][j] = board[i + 1][j].also { board[i + 1][j] = board[i][j] }
                maxCandy = maxOf(maxCandy, check())
                board[i][j] = board[i + 1][j].also { board[i + 1][j] = board[i][j] }
            }
        }
    }

    println(maxCandy)
}