class Solution {
    fun solution(s: String): IntArray {
        var s = s
        var zero = 0
        var cnt = 0
        while (s != "1") {
            zero += s.count { it == '0'}
            val removedZero = s.filter { it != '0' }
            val sLen = removedZero.length
            s = sLen.toString(2)
            cnt++
        } 
        return intArrayOf(cnt, zero)
    }
}