import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map(String::toInt)

    val board = Array(n) { IntArray(n) }

    data class Point(val x: Int, val y: Int)

    val chicken = mutableListOf<Point>()
    val house = mutableListOf<Point>()

    for (i in 0 until n) {
        val row = br.readLine().split(" ").map(String::toInt)
        for (j in 0 until n) {
            board[i][j] = row[j]
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (board[i][j] == 2) {
                chicken.add(Point(i,j))
            }
            if (board[i][j] == 1) {
                house.add(Point(i,j))
            }
        }
    }

    val chickenList = mutableListOf<List<Point>>()

    fun backtracking(idx: Int, check: BooleanArray, tmp: MutableList<Point>) {
        if (tmp.size == m) {
            chickenList.add(tmp)
            return
        }

        for (i in idx until chicken.size) {
            if (!check[i]) {
                val copyTmp = tmp.toMutableList()
                copyTmp.add(chicken[i])
                check[i] = true
                backtracking(i+1, check, copyTmp)
                check[i] = false

            }
        }
    }

    val check = BooleanArray(chicken.size)

    backtracking(0, check, mutableListOf<Point>())

    var result = Int.MAX_VALUE
    chickenList.forEach { chicken ->
        var dis = 0
        house.forEach { h ->
            var minDis = Int.MAX_VALUE
            chicken.forEach {c ->
                minDis = minOf(minDis, Math.abs(c.x-h.x)+Math.abs(c.y-h.y))
            }
            dis += minDis
        }
        result = minOf(result, dis)
    }
    println(result)

}