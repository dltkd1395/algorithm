class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
    
        return arr.sorted()
            .filter { it % divisor == 0 }
            .toIntArray()
            .let { if (it.isEmpty()) intArrayOf(-1) else it }
    }
}