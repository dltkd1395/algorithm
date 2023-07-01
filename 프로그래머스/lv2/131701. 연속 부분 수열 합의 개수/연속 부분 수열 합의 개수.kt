class Solution {
    fun solution(elements: IntArray): Int {
        var answer = mutableSetOf<Int>()
    
        val tmp = elements + elements
        
        (1..elements.size).forEach { s ->
           for (i in 0 until elements.size) {
              
               answer.add(tmp.slice(i until i+s).sum())
           } 
        }
        return answer.size
    }
}