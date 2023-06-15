

class Solution {
    fun solution(numbers: IntArray): String {
        
        if (numbers.all { it == 0 } ) {
            return "0"
        }

        return numbers.sortedBy { 
                (it.toString().repeat(10).take(4)).toInt() 
            }
            .reversed()
            .joinToString("")
     
    }
}