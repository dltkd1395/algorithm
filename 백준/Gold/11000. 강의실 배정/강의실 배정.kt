import java.util.PriorityQueue

data class Lecture(val start: Int, val end: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val times = List(n) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        Lecture(start, end)
    }.sortedWith(compareBy { it.start })

    val pq = PriorityQueue<Int>()
    var result = 0
    times.forEach { time ->
        pq.add(time.end)
        while (pq.isNotEmpty()) {
            if (pq.peek() > time.start) {
                break
            }
            pq.poll()
        }
        result = maxOf(result, pq.size)
    }
    println(result)
}
