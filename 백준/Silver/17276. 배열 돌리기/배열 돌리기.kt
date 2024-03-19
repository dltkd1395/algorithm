fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (n, d) = readLine().split(" ").map { it.toInt() }
        var matrix = List(n) { readLine().split(" ").map { it.toInt() } }
        val tmp = List(n) { i -> MutableList(n) { j -> matrix[i][j] } }
        val rotate = if (d < 0) 360 + d else d
        for (r in 0 until rotate / 45) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (i == j) {
                        tmp[i][j] = matrix[n / 2][j]
                    }

                    if (j == n / 2) {
                        tmp[i][j] = matrix[i][i]
                    }

                    if (i + j == n - 1) {
                        tmp[i][j] = matrix[i][n / 2]
                    }
                    if (i == n / 2) {
                        tmp[i][j] = matrix[n - j - 1][j]
                    }
                }
            }
            matrix = tmp.map { it.toMutableList() }.toList()
        }
        tmp.forEach {
            println(it.joinToString(" "))
        }
    }
}
