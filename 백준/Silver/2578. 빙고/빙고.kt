fun main() = with(System.`in`.bufferedReader()) {
    val board = Array(5) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    fun countBingo(): Int {
        var x = 0
        var y = 0
        var bingoCnt = 0
        for (i in 0 until 5) {
            val nx = x + i
            var cnt = 0
            for (j in 0 until 5) {
                val ny = y + j
                if (board[nx][ny] == -1) {
                    cnt++
                }
            }
            if (cnt == 5) {
                bingoCnt++
            }
        }

        for (j in 0 until 5) {
            val ny = y + j
            var cnt = 0
            for (i in 0 until 5) {
                val nx = x + i
                if (board[nx][ny] == -1) {
                    cnt++
                }
            }
            if (cnt == 5) {
                bingoCnt++
            }
        }

        var isBingo = true
        for (i in 0 until 5) {
            val nx = x + i
            val ny = y + i
            if (board[nx][ny] != -1) {
                isBingo = false
            }
        }

        if (isBingo) bingoCnt++
        isBingo = true
        x = 4
        y = 0
        for (i in 0 until 5) {
            val nx = x - i
            val ny = y + i
            if (board[nx][ny] != -1) {
                isBingo = false
            }
        }
        if (isBingo) bingoCnt++

        return bingoCnt
    }

    fun getBingoCount(): Int {
        repeat(5) { r ->
            val numbers = readLine().split(" ").map { it.toInt() }
            numbers.forEachIndexed() { c, num ->
                for (i in 0 until 5) {
                    for (j in 0 until 5) {
                        if (board[i][j] == num) {
                            board[i][j] = -1
                            val cnt = countBingo()
                            if (cnt >= 3) {
                                return r * 5 + c + 1
                            }
                        }
                    }
                }
            }
        }
        return 25
    }
    println(getBingoCount())
}
