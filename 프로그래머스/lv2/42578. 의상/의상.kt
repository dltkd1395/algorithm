class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
       return clothes.groupingBy { it[1] }
            .eachCount()
            .mapValues { it.value + 1}
            .values
            .toList()
            .reduce { acc, v -> acc * v } -1
    }
}