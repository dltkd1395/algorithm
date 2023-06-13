import java.util.*

class Solution {
    
    data class Node(val num: Int, val weight: Int): Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return weight.compareTo(other.weight)
        }
    }
    
    
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {

        val graph = Array(N+1) { mutableListOf<Node>() }
        val distance = (0..N).map { Int.MAX_VALUE }.toMutableList()
        for (r in road) {
            graph[r[0]].add(Node(r[1], r[2]))
            graph[r[1]].add(Node(r[0], r[2]))
        }
        
       fun dijkstra(start: Int) {
           val q = PriorityQueue<Node>()

           q.add(Node(start, 0))
           distance[start] = 0
           

            while (q.isNotEmpty()) {
                val node = q.poll()
                if (distance[node.num] < node.weight) continue

                for (i in graph[node.num]) {
                    val cost = node.weight + i.weight

                    if (cost < distance[i.num]) {
                        distance[i.num] = cost
                        q.add(Node(i.num, cost))
                    }
                }
            }
        
        }
       
        dijkstra(1)
        
        return distance.filter { it <= k }.size
    }
}