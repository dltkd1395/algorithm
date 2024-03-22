fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val calendar = IntArray(366)

    repeat(n) {
        val (s, e) = readLine().split(" ").map { it.toInt() }

        for (i in s until e + 1) {
            calendar[i] += 1
        }
    }

    var row = 0
    var col = 0
    var result = 0

    for (i in 0 until 366) {
        if (calendar[i] != 0) {
            row = maxOf(row, calendar[i])
            col += 1
        } else {
            result += row * col
            row = 0
            col = 0
        }
    }
    result += row * col
    println(result)
}
