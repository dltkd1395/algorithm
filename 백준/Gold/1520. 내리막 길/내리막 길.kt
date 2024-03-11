lateinit var dp: List<MutableList<Int>>
var n: Int = 0
var m: Int = 0
val dx = listOf(1, 0, 0, -1)
val dy = listOf(0, 1, -1, 0)
val matrix = List(500) { MutableList(500) { 0 } }
fun main() = with(System.`in`.bufferedReader()) {
    val (nI, mI) = readLine().split(" ").map { it.toInt() }
    n = nI
    m = mI

    (0 until n).forEach { i ->
        val row = readLine().split(" ").map { it.toInt() }
        (0 until m).forEach { j ->
            matrix[i][j] = row[j]
        }
    }
    dp = List(n) { MutableList(m) { -1 } }
    println(dfs(0, 0))
}

fun dfs(x: Int, y: Int): Int {
    if (x == n - 1 && y == m - 1) {
        return 1
    }
    if (dp[x][y] != -1) {
        return dp[x][y]
    }
    dp[x][y] = 0
    (0 until 4).forEach { i ->
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx in 0 until n && ny in 0 until m && matrix[x][y] > matrix[nx][ny]) {
            dp[x][y] += dfs(nx, ny)
        }
    }
    return dp[x][y]
}
