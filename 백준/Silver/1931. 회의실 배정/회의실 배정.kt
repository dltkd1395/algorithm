fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val rooms = List(n) { readLine().split(" ").map { it.toInt() } }
        .sortedWith(compareBy({ it[1] }, { it[0] }))
    var result = 1
    var currentEnd = rooms[0][1]
    (1 until n).forEach { i ->
        if (rooms[i][0] >= currentEnd) {
            result++
            currentEnd = rooms[i][1]
        }
    }
    println(result)
}