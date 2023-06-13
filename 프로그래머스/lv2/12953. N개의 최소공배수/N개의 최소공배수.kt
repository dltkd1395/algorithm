class Solution {
    
    fun gcd(a:Int, b: Int): Int = if (b != 0) gcd(b, a%b) else a

    
    fun solution(arr: IntArray): Int {
        return arr.toList()
            .slice(1 until arr.size)
            .fold(arr[0]) { acc, v -> acc*v/gcd(acc, v)}
    }
}