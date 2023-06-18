class Solution {

    val dx = intArrayOf(1, 0, -1)
    val dy = intArrayOf(0, 1, -1)

    fun solution(n: Int): IntArray {

        val board = Array(n) { IntArray(n) }

        if (n == 1) {
            return intArrayOf(1)
        }

        var x = -1
        var y = 0
        var num = 1
        var d = 0

        for (i in n downTo 1) {
            repeat(i) {
                x += dx[d]
                y += dy[d]
                board[x][y] = num++
            }
            d = (d + 1) % 3
        }

        return board.flatMap { it.filter { it != 0 } }.toIntArray()
    }
}