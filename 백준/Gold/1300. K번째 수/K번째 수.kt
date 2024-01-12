fun main() {
    val n = readln().toLong()
    val k = readln().toLong()

    println(getResult(n, k))
}

fun getResult(n: Long, k: Long): Long {
    var start = 1L
    var end = n * n
    while (start <= end) {
        val mid = (start + end) / 2
        val index = findIndex(mid, n)
        when {
            index < k -> start = mid + 1
            else -> end = mid - 1
        }
    }
    return start
}

fun findIndex(mid: Long, n: Long): Long {
    var index = 0L
    (1..n).forEach { idx ->
        index += minOf(mid / idx, n)
    }
    return index
}