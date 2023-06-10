class Solution {
    
    fun gcd(a: Int, b: Int): Int = if (b != 0 ) gcd(b, a%b) else a
    
    fun solution(n: Int, m: Int): IntArray {
        return intArrayOf(gcd(n,m), n*m/gcd(n,m))
    }
}