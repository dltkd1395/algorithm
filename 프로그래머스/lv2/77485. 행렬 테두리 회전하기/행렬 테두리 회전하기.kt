class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        val matrix = Array(rows) { IntArray(columns) }
        
        var n = 1
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                matrix[i][j] = n
                n++
            }
        }
        
        fun rotate(x1:Int,y1:Int,x2:Int,y2:Int): Int {
           
            val tmp = matrix[x1][y2]
            var minValue = matrix[x1][y2]
            
            for (i in y2 downTo y1+1) {
                matrix[x1][i] = matrix[x1][i-1]
                minValue = minOf(minValue, matrix[x1][i])
            }
            
            for (i in x1 until x2) {
                matrix[i][y1] = matrix[i+1][y1]
                minValue = minOf(minValue,matrix[i][y1])
            }
            
            for (i in y1 until y2) {
                matrix[x2][i] = matrix[x2][i+1]
                minValue = minOf(minValue,matrix[x2][i])
            }
            
            for (i in x2 downTo x1+1) {
                matrix[i][y2] = matrix[i-1][y2]
                minValue = minOf(minValue,matrix[i][y2])
            }
            
            matrix[x1+1][y2] = tmp
            
            return minValue
        }
        
        queries.forEach { query ->
            val (x1,y1,x2,y2) = query
            answer.add(rotate(x1-1,y1-1,x2-1,y2-1))
        }
        
        return answer.toIntArray()
    }
}