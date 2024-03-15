fun main() = with(System.`in`.bufferedReader()) {
    val (r, c, q) = readLine().split(" ").map { it.toInt() }
    val picture =
        List(r + 1) { MutableList(c + 1) { 0 } }
//
    for (i in 1 until r + 1) {
        val arr = readLine().split(" ").map { it.toInt() }
        for (j in 1 until c + 1) {
            picture[i][j] = picture[i][j - 1] + arr[j - 1]
        }
    }

    for (j in 1 until c + 1) {
        for (i in 1 until r + 1) {
            picture[i][j] += picture[i - 1][j]
        }
    }

    repeat(q) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        val total = picture[x2][y2] - picture[x1 - 1][y2] - picture[x2][y1 - 1] + picture[x1 - 1][y1 - 1]
        println(total / ((x2 - x1 + 1) * (y2 - y1 + 1)))
    }
}
