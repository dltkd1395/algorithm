import  kotlin.collections.ArrayDeque

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0
        var a = queue1.sum().toLong()
        var b = queue2.sum().toLong()
        
        val q1 = ArrayDeque<Long>()
        val q2 = ArrayDeque<Long>()
        
        queue1.forEach{ q1.add(it.toLong()) }
        queue2.forEach{ q2.add(it.toLong()) }
        
        while (a!=b) {
            
            if (answer == queue1.size*3) {
                return -1
            }
            
            if (a > b) {
                val num = q1.removeFirst()
                b += num
                a -= num
                q2.add(num)
            } else {
                val num = q2.removeFirst()
                b -= num
                a += num
                q1.add(num)
            }
            answer++
        }
        
        
        return answer
    }
}