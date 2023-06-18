class Solution {
    
    
    fun solution(arr: Array<IntArray>): IntArray {
        
        val arr = arr
        
        val num = arr.size
        
        fun check(n: Int, x: Int, y: Int): Boolean {
            val number = arr[x][y]
            (0 until n).forEach { r ->
                (0 until n).forEach { c ->
                    if (number != arr[x+r][y+c]) {
                        return false
                    }
                }
            }
            return true
        }
        
        var zero = 0
        var one = 0

        fun divide(x: Int, y: Int, n: Int) {

            if (check(n, x, y)) {
                if (arr[x][y] == 1) one++ else zero++
                return 
            }
            
            divide(x, y, n/2)
            divide(x, y+n/2, n/2)
            divide(x+n/2, y, n/2)
            divide(x+n/2, y+n/2, n/2)
        }
        
        divide(0,0,num)

        return intArrayOf(zero, one)
    }
}