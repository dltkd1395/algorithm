import kotlin.math.abs

class Solution {
   
    var answer = 0
    lateinit var colArray: IntArray
    
    fun checkQueen(row:Int, col: Int, n: Int): Boolean {
        for (r in 0 until row) {
            if (colArray[r] == col || abs(colArray[r]-col) == abs(r-row)) {
                return false
            }
        }
        return true
    }
    
    fun queen(n: Int, row: Int) {
        
        if (row==n) {
            answer++
            return
        }
        
        for (col in 0 until n) {
            if (checkQueen(row, col, n)) {
                colArray[row] = col 
                queen(n, row+1)
                colArray[row] = -1
            }
        }
    }
    
    fun solution(n: Int): Int {
    
        colArray = IntArray(n) { -1 }
        queen(n, 0)
        return answer
    }
}