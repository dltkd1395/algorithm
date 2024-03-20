fun main() = with(System.`in`.bufferedReader()) {
    val matrix = Array(19) { readLine().split(" ").map { it.toInt() } }
    val dx = arrayOf(0, 1, -1, 1)
    val dy = arrayOf(1, 1, 1, 0)

    fun dfs(visited: Array<IntArray>, i: Int, j: Int, d: Int) {
        val nx = dx[d] + i
        val ny = dy[d] + j

        if (nx in 0 until 19 && ny in 0 until 19) {
            if (visited[nx][ny] == 0 && matrix[nx][ny] == matrix[i][j]) {
                visited[nx][ny] = visited[i][j] + 1
                dfs(visited, nx, ny, d)
            }
        }
    }

    data class Position(val x: Int, val y: Int, val stone: Int)

    var result = mutableListOf<Position>()
    for (i in 0 until 19) {
        for (j in 0 until 19) {
            if (matrix[i][j] > 0) {
                for (d in 0 until 4) {
                    var cnt = 1
                    var nx = dx[d] + i
                    var ny = dy[d] + j

                    while(nx in 0 until 19 && ny in 0 until 19 && matrix[nx][ny] == matrix[i][j]) {
                        cnt++

                        if (cnt == 5) {
                            if (i - dx[d] in 0 until 19 && j - dy[d] in 0 until 19) {
                                if (matrix[i - dx[d]][j - dy[d]] == matrix[i][j]) {
                                    break
                                }
                            }

                            if (nx + dx[d] in 0 until 19 && ny + dy[d] in 0 until 19) {
                                if (matrix[nx + dx[d]][ny + dy[d]] == matrix[i][j]) {
                                    break
                                }
                            }
                            println(matrix[i][j])
                            println("${i + 1} ${j + 1}")
                            return
                        }
                        nx += dx[d]
                        ny += dy[d]
                    }
                }
            }
        }
    }
    println(0)
}
