import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val solutions = readln().split(" ").map { it.toLong() }.sorted()
    var result = Long.MAX_VALUE
    val resultList = MutableList(3) { 0L }
    (0 until n - 1).forEach { i ->
        (i + 1 until n).forEach { j ->
            var start = j + 1
            var end = n - 1
            while (start <= end) {
                val mid = (start + end) / 2
                val sum = solutions[i] + solutions[j] + solutions[mid]
                if (result > abs(sum)) {
                    result = abs(sum)
                    resultList[0] = solutions[i]
                    resultList[1] = solutions[j]
                    resultList[2] = solutions[mid]
                }
                if (sum < 0) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
        }
    }
    println(resultList.sorted().joinToString(" "))
}