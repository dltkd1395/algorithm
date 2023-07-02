import kotlin.collections.ArrayDeque

class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        
        val me = mutableSetOf<Int>() 
        val bro = mutableSetOf<Int>()
        val n = topping.size
        val left = ArrayDeque<Int>()
        val right = ArrayDeque<Int>()
        (0 until n).forEach { i ->
            me.add(topping[i])
            bro.add(topping[n - i - 1])
            left.add(me.size)
            right.addFirst(bro.size)
        }
        
        (0 until n-1).forEach {
            if (left[it] == right[it+1]) answer++
        }
        
        return answer
    }
}