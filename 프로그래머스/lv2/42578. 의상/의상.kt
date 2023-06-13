class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
       return clothes.groupBy { it[1] }
            .values
            .map { it.size + 1}
            .reduce(Int::times) -1
    }
}