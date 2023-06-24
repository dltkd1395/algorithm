class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer = mutableListOf<Int>()
        
        (left..right).forEach {
            val x = it/n.toLong()+1
            val y = it%n.toLong()+1
            answer.add(maxOf(x,y).toInt())
        }

        
        return answer.toIntArray()
    }
}