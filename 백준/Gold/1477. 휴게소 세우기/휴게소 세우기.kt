import java.util.StringTokenizer

fun main() {
    val (n, m, l) = readln().split(" ").map { it.toInt() }
    val distances = StringTokenizer(readln(), " ")
    var arr = MutableList(n + 2) { 0 }
    arr[0] = 0
    arr[1] = l
    val intervalList = mutableListOf<Int>()
    (2 until n + 2).forEach { index ->
        arr[index] = distances.nextToken().toInt()
    }
    arr.sortDescending()

    (0 until arr.size - 1).forEach { index ->
        intervalList.add(arr[index] - arr[index + 1])
    }

    var start = 1
    var end = l - 1
    while (start <= end) {
        val mid = (start + end) / 2
        val cnt = intervalList.sumOf { it / mid } - intervalList.count { it % mid == 0 }
        if (cnt > m) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    println(start)
}
