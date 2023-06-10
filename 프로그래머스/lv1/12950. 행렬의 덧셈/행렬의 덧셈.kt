class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = Array (arr1.size) { IntArray(arr1[0].size) { 0 } }
        
        arr1.forEachIndexed { r, row ->
            arr1[r].zip(arr2[r]).forEachIndexed { c, (first,second) ->
                answer[r][c] = first+second
            }
        }
        
        return answer
    }
}