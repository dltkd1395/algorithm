fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val distances = List(n) {
        readln().toInt()
    }.sorted()
    println(findMaxDistance(distances, c))
}

fun findMaxDistance(distances: List<Int>, router: Int): Int {
    var start = 1
    var end = distances.last() - distances.first()
    var result = 0
    while (start <= end) {
        val mid = (start + end) / 2
        val cnt = getRouterCount(mid, distances)
        if (cnt >= router) {
            result = maxOf(result, mid)
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return result
}

fun getRouterCount(minDistance: Int, distances: List<Int>): Int {
    var currentDistance = distances[0]
    var cnt = 1
    distances.forEach { dist ->
        if (dist - currentDistance >= minDistance) {
            currentDistance = dist
            cnt++
        }
    }
    return cnt
}