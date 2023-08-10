
class Solution {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()
    
        val x1 = startX
        val y1 = startY
        balls.forEachIndexed { index, (x2, y2) ->
            when {
                x1 == x2 -> {
                    val d1 = (y2 - y1) * (y2 - y1) + 4 * x1 * x1
                    val d2 = (y2 - y1) * (y2 - y1) + 4 * (m - x1) * (m - x1)
                    val d3 = if (y1 < y2) (y1 + y2) * (y1 + y2) else (2 * n - y1 - y2) * (2 * n - y1 - y2)
                    answer.add(minOf(minOf(d1, d2), d3))
                }
                y1 == y2 -> {
                    val d1 = (x2 - x1) * (x2 - x1) + 4 * y1 * y1
                    val d2 = (x2 - x1) * (x2 - x1) + 4 * (n - y1) * (n - y1)
                    val d3 = if (x1 < x2) (x1 + x2) * (x1 + x2) else (2 * m - x1 - x2) * (2 * m - x1 - x2)
                    answer.add(minOf(minOf(d1, d2), d3))
                }
                else -> {
                    val d1 = (x2 - x1) * (x2 - x1) + (y2 + y1) * (y2 + y1)
                    val d2 = (x2 + x1) * (x2 + x1) + (y2 - y1) * (y2 - y1)
                    val d3 = (y2 - y1) * (y2 - y1) + (2 * m - x1 - x2) * (2 * m - x1 - x2)
                    val d4 = (x2 - x1) * (x2 - x1) + (2 * n - y1 - y2) * (2 * n - y1 - y2)
                    answer.add(minOf(minOf(d1, d2), minOf(d3, d4)))
                }
            }
        }
        return answer.toIntArray()
    }
}