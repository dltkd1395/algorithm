import kotlin.collections.ArrayDeque

class Solution {
    fun solution(maps: Array<String>): Int {
        var answer: Int = 0
        var start = listOf<Int>()
        var end = listOf<Int>()
        var lever = listOf<Int>()
        val r = maps.size
        val c = maps[0].length
        
        for (row in 0 until r) {
            for (col in 0 until c) {
                when (maps[row][col]) {
                    'S' -> start = listOf(row, col)
                    'E' -> end = listOf(row, col)
                    'L' -> lever = listOf(row, col)
                }
            }
        }
        
        val dx = listOf(0,1,0,-1)
        val dy = listOf(1,0,-1,0)
        
        fun bfs(target: List<Int>, start: List<Int>): Int {
            val visited = Array(r) { MutableList(c) { 0 }}
            val q = ArrayDeque<List<Int>>()
    
            val (sx,sy) = start
            visited[sx][sy] = 1
            q.add(listOf(sx,sy))
    
            while (q.isNotEmpty()) {
                val (x,y) = q.removeFirst()

                for (d in 0 until 4) {
                    val (nx,ny) = listOf(x+dx[d], y+dy[d])
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if (maps[nx][ny] != 'X' && visited[nx][ny] == 0) {
                            visited[nx][ny] = visited[x][y] + 1
                            q.add(listOf(nx,ny))
                        }
                    }
                }
            }
            val (tx,ty) = target
            return visited[tx][ty] - 1
        }
        

        val result1 = bfs(lever, start)
     
        if (result1 == -1) return -1  
        val result2 = bfs(end, lever)
        if (result2 == -1) return -1
        return result1 + result2
    }
}