import java.util.PriorityQueue

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        
        val stack = mutableListOf<Pair<Int,Int>>()
        
        priorities.mapIndexed { i, v -> Pair(i, v) }.forEach {
            stack.add(it)
        }
        
        var maxValue = stack.maxByOrNull { it.second }
        while (stack.isNotEmpty()) {
            val (idx, progress) = stack.removeFirst()
          
            if (progress == maxValue?.second) {
                answer++
                if (idx == location) {
                    break
                }
                maxValue = stack.maxByOrNull { it.second }
            } else {
                stack.add(Pair(idx, progress))
            }
            
        }
        
        return answer
    }
}