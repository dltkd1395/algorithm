class Solution {
    
    fun solution(x: Int, n: Int): LongArray {
        val minValue = Long.MIN_VALUE
        val maxValue = Long.MAX_VALUE
        val x = x.toLong()
      
        return when {
            x > 0 -> (x..x*n).step(x)
                .filter { it >= minValue && it <= maxValue }
                .toLongArray()
            x < 0 ->  (x downTo x*n).step(-x)
                .filter { it >= minValue && it <= maxValue }
                .toLongArray()
            else -> LongArray(n) { 0 }
        }
    }
}