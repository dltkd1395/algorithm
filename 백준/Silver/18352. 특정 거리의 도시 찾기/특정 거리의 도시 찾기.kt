fun main() {
    val (N, M, K, X) = readln().split(" ").map { it.toInt() }
    val road = List(N + 1) { mutableListOf<Int>() }
    val distances = MutableList(N + 1) { -1 }
    repeat(M) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        road[x].add(y)
    }
    bfs(X, K, road, distances)
}

fun bfs(X: Int, K: Int, road: List<List<Int>>, distances: MutableList<Int>) {
    val shortestDistances = mutableListOf<Int>()
    distances[X] += 1
    val deque = ArrayDeque<Int>()
    deque.add(X)

    while (deque.isNotEmpty()) {
        val x = deque.removeFirst()
        if (K == distances[x]) {
            shortestDistances.add(x)
        }
        road[x].forEach { n ->
            if (distances[n] == -1) {
                distances[n] = distances[x] + 1
                deque.add(n)
            }
        }
    }
    if (shortestDistances.isEmpty()) {
        println(-1)
    } else {
        shortestDistances.sorted().forEach { distance ->
            println(distance)
        }
    }
}
