fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val rectangle = Array(111) { IntArray(111) }

    repeat(n) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        for (i in x until x + 10) {
            for (j in y until y + 10) {
                rectangle[i][j] = 1
            }
        }
    }

    for (i in 0 until 99) {
        for (j in 0 until 100) {
            if (rectangle[i][j] > 0 && rectangle[i + 1][j] > 0) {
                rectangle[i + 1][j] = rectangle[i][j] + 1
            }
        }
    }
    var answer = 0
    for (i in 0 until 100) {
        for (j in 0 until 100) {
            var h = 100

            for (k in j until 100) {
                h = minOf(h, rectangle[i][k])
                if (h == 0) {
                    break
                }
                answer = maxOf(answer, h * (k - j + 1))
            }
        }
    }
    println(answer)
}