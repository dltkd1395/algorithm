fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val matrix = List(n + 1) { MutableList(m + 1) { 0 } }
    for (i in 1 until n + 1) {
        val arr = readLine().split(" ").map { it.toInt() }
        matrix[i][1] = arr[0]
        for (j in 2 until m + 1) {
            matrix[i][j] = matrix[i][j - 1] + arr[j - 1]
        }
    }
    val k = readLine().toInt()
    for (j in 1 until m + 1) {
        for (i in 2 until n + 1) {
            matrix[i][j] += matrix[i - 1][j]
        }
    }

    repeat(k) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        println(matrix[x2][y2] - matrix[x2][y1 - 1] - matrix[x1 - 1][y2] + matrix[x1 - 1][y1 - 1])
    }
}