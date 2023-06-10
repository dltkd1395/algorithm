class Solution {
    fun solution(a: Int, b: Int): Long {
        var a = a
        var b = b
        if (b < a) a = b.also { b=a }

        return (a..b).fold(0) { acc, v -> acc + v }
    }
}