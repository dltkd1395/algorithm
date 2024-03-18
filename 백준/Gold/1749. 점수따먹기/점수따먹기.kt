fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val matrix = List(n + 1) { MutableList(m + 1) { 0 } }
    for (i in 1 until n + 1) {
        val arr = readLine().split(" ").map { it.toInt() }
        for (j in 1 until m + 1) {
            matrix[i][j] = arr[j - 1]
        }
    }
    var result = -10000
    for (i in 1 until n + 1) {
        for (j in 1 until m + 1) {
            matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] + matrix[i][j] - matrix[i - 1][j - 1]
        }
    }

    for (si in 1 until n + 1) {
        for (sj in 1 until m + 1) {
            for (ei in si until n + 1) {
                for (ej in sj until m + 1) {
                    result =
                        maxOf(result, matrix[ei][ej] - matrix[si - 1][ej] - matrix[ei][sj - 1] + matrix[si - 1][sj - 1])
                }
            }
        }
    }
    println(result)
}