fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val picture = Array(n) { readLine().toMutableList() }
    var dist = 3000
    for (j in 0 until m) {
        var start = n - 1
        for (i in n - 2 downTo 0) {
            if (picture[i][j] == '#') {
                start = minOf(start, i)
            }
            if (picture[i][j] == 'X') {
                dist = minOf(dist, start - i - 1)
            }
        }
    }

    for (j in 0 until m) {
        for (i in n - dist - 1 downTo 0) {
            if (picture[i][j] == 'X') {
                picture[i + dist][j] = 'X'
                picture[i][j] = '.'
            }
        }
    }
    picture.forEach {
        println(it.joinToString(""))
    }
}