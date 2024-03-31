fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val mindBoard = Array(n) { readLine() }
    val board = Array(n) { readLine() }
    val result = Array(n) { CharArray(n) { '.' } }
    val dx = arrayOf(1, 0, 0, -1, 1, 1, -1 ,-1)
    val dy = arrayOf(0, 1, -1, 0 ,-1, 1, -1 ,1)

    fun getMindCount(x: Int, y: Int): Int {
        var cnt = 0

        for (i in 0 until 8) {
            val nx = dx[i] + x
            val ny = dy[i] + y

            if (nx in 0 until n && ny in 0 until n) {
                if (mindBoard[nx][ny] == '*') {
                    cnt++
                }
            }
        }
        return cnt
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            for (d in 0 until 8) {
                if (board[i][j] == 'x' && mindBoard[i][j] == '.') {
                    result[i][j] = getMindCount(i, j).digitToChar()
                }

                if (board[i][j] == 'x' && mindBoard[i][j] == '*') {
                    for (x in 0 until n) {
                        for (y in 0 until n) {
                            if (mindBoard[x][y] == '*') {
                                result[x][y] = '*'
                            }
                        }
                    }
                }
            }
        }
    }
    result.forEach { arr ->
        println(arr.joinToString(""))
    }
}
