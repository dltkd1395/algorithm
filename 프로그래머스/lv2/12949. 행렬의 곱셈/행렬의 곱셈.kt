class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = mutableListOf<IntArray>()
        
        for (i in 0 until arr1.size) {
            val lst = mutableListOf<Int>()
            for (j in 0 until arr2[0].size) {
                var count = 0
                for (k in 0 until arr2.size) {
                    count += arr1[i][k] * arr2[k][j]
                }
                lst.add(count)
                
            }
            answer.add(lst.toIntArray())
            
        }
        
        return answer.toTypedArray()
    }
}