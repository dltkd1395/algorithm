class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = mutableListOf<IntArray>()
        
        for (i1 in 0 until arr1.size) {
            val lst = mutableListOf<Int>()
            for (j2 in 0 until arr2[0].size) {
                var count = 0
                for (i2 in 0 until arr2.size) {
                    count += arr1[i1][i2%arr1[0].size] * arr2[i2][j2]
                }
                lst.add(count)
                
            }
            answer.add(lst.toIntArray())
            
        }
        
        return answer.toTypedArray()
    }
}