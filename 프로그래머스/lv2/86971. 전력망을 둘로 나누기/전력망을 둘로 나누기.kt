import kotlin.collections.ArrayDeque

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = n
        
        val tree = Array(n+1) { mutableListOf<Int>() }
        
        wires.forEachIndexed { i, (x,y) ->
            tree[x].add(y)
            tree[y].add(x)
        }
        
        fun bfs(tree: Array<MutableList<Int>>, node: Int, visited: BooleanArray, wire: IntArray): Int {
            val q = ArrayDeque<Int>()
            
            q.add(node)
            visited[node] = true
            var cnt = 0
            
            while (q.isNotEmpty()) {
                val nd = q.removeFirst()
                cnt++
                for (wireNum in tree[nd]) {
                    if (!((nd == wire[0] && wireNum == wire[1]) || (nd == wire[1] && wireNum == wire[0]))) {
                        if (!visited[wireNum]) {
                            visited[wireNum] = true
                            q.add(wireNum)
                        }
                    }
                }
            }
            return cnt
        }
        
        wires.forEach { wire ->
            val visited = BooleanArray(n+1)
            val graph = mutableListOf<Int>()
            
            for (i in 1 until n+1) {
                if (!visited[i]) {
                    graph.add(bfs(tree, i, visited, wire))
                }
            }
            answer = minOf(answer, Math.abs(graph[0] - graph[1]))
        }
        
        return answer
    }
}