fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val board = List(n) { readln().split("").subList(1, m + 1) }
    var result = Int.MAX_VALUE
    (0 until n - 7).forEach { i ->
        (0 until m - 7).forEach { j ->
            var whiteCount = 0
            var blackCount = 0
            (i until i + 8).forEach { k ->
                (j until j + 8).forEach { l ->
                    if (board[k][l] == if ((k + l) % 2 == 0) "W" else "B") {
                        whiteCount++
                    } else {
                        blackCount++
                    }
                }
            }
            result = minOf(result, whiteCount, blackCount)
        }
    }
    println(result)
}
