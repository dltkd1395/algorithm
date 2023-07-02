class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        
        val container = mutableListOf<Int>() 
        var i = 1

        while (i != order.size+1) {
            container.add(i)
            while (container.isNotEmpty() && container.last() == order[answer]) {
                answer++
                container.removeLast()
            }
            i++
        } 
        
        return answer
    }
}