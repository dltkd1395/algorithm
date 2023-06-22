import kotlin.collections.ArrayDeque

class Solution {

    fun solution(places: Array<Array<String>>): IntArray {
        var answer = mutableListOf<Int>()
        
        
        
        data class Point(val distance: Int, val r: Int, val c: Int)
        
        val dx = listOf(1,0,0,-1)
        val dy = listOf(0,1,-1,0)
        
        fun bfs(place: Array<String>, row: Int, col: Int): Boolean {
            val visited = Array(5) { BooleanArray(5) { false } }
            val q = ArrayDeque<Point>()
            q.add(Point(0, row, col))
            visited[row][col] = true
            
            while (q.isNotEmpty()) {
                val (dis, r, c) = q.removeFirst()
                
                if (dis > 2) continue
                
                if (dis != 0 && place[r][c] == 'P') return false
                
                for (d in 0 until 4) {
                    val nx = dx[d] + r
                    val ny = dy[d] + c
                    
                    if (nx>=0 && nx < 5 && ny >= 0 && ny < 5) {
                        if (!visited[nx][ny] && place[nx][ny] != 'X') {
                            visited[nx][ny] = true
                            q.add(Point(dis+1, nx,ny))
                        }
                    }
                }
                
            }
            return true
        }
        
        fun check(place: Array<String>): Boolean {
            for (i in 0 until 5) {
                for (j in 0 until 5) {
                    if (place[i][j] == 'P') {
                        if (!bfs(place, i,j)) return false
                    }
                }
            }
            return true
        }
        
        places.forEach { place ->
            if (check(place)) answer.add(1) else answer.add(0)
        }
        
        return answer.toIntArray()
    }
}