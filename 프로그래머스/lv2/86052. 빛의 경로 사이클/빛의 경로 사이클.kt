class Solution {
    fun solution(grid: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        val n = grid.size
        val m = grid[0].length
        
        val dx = intArrayOf(1,0,-1, 0)
        val dy = intArrayOf(0,1,0,-1)
        
        val visited = Array(n) { Array(m) { BooleanArray(4) } }
        
        fun cycle(r:Int, c:Int, d: Int) {
            var nx = r
            var ny = c
            var nd = d
            var cnt = 0
            while (true) {
                if (visited[nx][ny][nd]) break
                
                visited[nx][ny][nd] = true
                nd = when (grid[nx][ny]) {
                    'L' -> (nd+1)%4
                    'R' -> (nd+3)%4
                    else -> nd
                }
                nx = (nx+dx[nd]+n)%n
                ny = (ny+dy[nd]+m)%m
                cnt++
                
            }
            if (cnt > 0) answer.add(cnt)
        }
        
        for (r in 0 until n) {
            for (c in 0 until m) {
                for (d in 0 until 4) {
                    cycle(r,c,d)
                }
            }
        }
        
        
        return answer.sorted().toIntArray()
    }
}