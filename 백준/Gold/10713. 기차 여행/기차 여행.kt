fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val plan = readLine().split(" ").map { it.toInt() }
    val cost = List(n - 1) { readLine().split(" ").map { it.toInt() } }
    val count = MutableList(n + 1) { 0 }

    for (i in 0 until m - 1) {
        val lower = minOf(plan[i], plan[i + 1])
        val higher = maxOf(plan[i], plan[i + 1])
        count[lower] += 1
        count[higher] -= 1
    }

    var sum = 0
    var result = 0L

    for (i in 0 until n - 1) {
        sum += count[i + 1]
        result += minOf(cost[i][0].toLong() * sum, cost[i][1].toLong() * sum + cost[i][2])
    }

    bw.use { it.write("$result\n") }
}