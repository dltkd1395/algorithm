fun main() {
    val (N, M, V) = readln().split(" ").map { it.toInt() }

    var graph = List(N + 1) { mutableListOf<Int>() }

    repeat(M) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        graph[x].add(y)
        graph[y].add(x)
    }
    graph = graph.map { it.sorted().toMutableList() }
    var visited = MutableList(N + 1) { 0 }
    dfs(graph, V, visited)
    visited = MutableList(N + 1) { 0 }
    println()
    bfs(graph, V, visited)
}

fun dfs(graph: List<MutableList<Int>>, V: Int, visited: MutableList<Int>) {
    print("$V ")
    visited[V] = 1

    graph[V].forEach { num ->
        if (visited[num] == 0) {
            dfs(graph, num, visited)
        }
    }
}

fun bfs(graph: List<MutableList<Int>>, V: Int, visited: MutableList<Int>) {
    val deque = ArrayDeque<Int>()
    deque.add(V)
    visited[V] = 1
    while (deque.isNotEmpty()) {
        val v = deque.removeFirst()
        print("$v ")

        graph[v].forEach { num ->
            if (visited[num] == 0) {
                visited[num] = 1
                deque.add(num)
            }
        }
    }
}