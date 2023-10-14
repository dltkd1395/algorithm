class Solution {
    fun solution(n: Int): Int {
        var res = 0
        n.toString().forEach{res+=it.toInt() - '0'.toInt()}
        return res
    }
}