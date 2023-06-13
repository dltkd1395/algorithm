import kotlin.math.ceil

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var a = a.toDouble()
        var b = b.toDouble()
        return generateSequence(Pair(a, b)) { (a, b) ->
                Pair(ceil(a / 2),  ceil(b / 2))
            }.takeWhile { (a, b) ->
                !(a % 2.0 == 0.0 && a - 1 == b) && !(a % 2.0 != 0.0 && a + 1 == b)
            }.count()+1
    }
}