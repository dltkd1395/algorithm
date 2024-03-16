fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val plan = readLine().split(" ").map { it.toInt() }
    val cost = List(n - 1) { readLine().split(" ").map { it.toInt() } }
    val count = MutableList(n + 1) { 0 }
    for (i in 0 until m - 1) {
        if (plan[i] < plan[i + 1]) {
            count[plan[i]] += 1
            count[plan[i + 1]] -= 1
        } else {
            count[plan[i]] -= 1
            count[plan[i + 1]] += 1
        }
    }

    var sum = 0
    var result = 0

    for (i in 0 until n - 1) {
        sum += count[i + 1]
        result += minOf(cost[i][0] * sum, cost[i][1] * sum + cost[i][2])
    }
    println(result)
}
