class Solution {
    val direction = mapOf(
        "E" to intArrayOf(0,1), 
        "W" to intArrayOf(0,-1),
        "S" to intArrayOf(1,0),
        "N" to intArrayOf(-1,0)
    )
    
    fun isStartingPoint(park: Array<String>, i: Int, j: Int): Boolean {
        if (park[i][j] == 'S') {
            return true
        }
        return false
    }
    
    fun isCheckRoute(park:Array<String>, n:Int,m:Int,nx:Int,ny:Int,op:String,num:Int):Boolean {
        var nx = nx
        var ny = ny
        for (i in 0 until num) {
            val (dx, dy) = direction[op] as IntArray
            nx+=dx
            ny+=dy
            
            if (nx<0 || nx>=n || ny<0 || ny>=m) {
                return false
            } 
            
            if (park[nx][ny] == 'X') {
                return false
            }
        }
        return true
    }
    
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        
        var sx = 0
        var sy = 0
        val n = park.size
        val m = park[0].length
        
        for (i in 0 until n) {
            var isCheck = false
            for (j in 0 until m) {
                if (isStartingPoint(park, i,j)) {
                    isCheck = true
                    sx = i
                    sy = j
                    break
                }
            }
            if (isCheck) {
                break
            }
        }
        
        for (route in routes) {
            var (op, num) = route.split(" ")
            var number = num.toInt()
            val (x,y) = direction[op] as IntArray
            if (isCheckRoute(park,n,m,sx,sy,op,number)) {
                sx += x*number
                sy += y*number
            }
        }
        answer = intArrayOf(sx,sy)
        
        return answer
    }
}