class Solution {
    fun solution(arr: IntArray): IntArray {
        return arr.filterNot { it == arr.minOrNull() }
            .ifEmpty { listOf(-1) }
            .toIntArray()
    }
}