class Solution {
    
    fun gcd(a:Long, b: Long): Long = if (b!=0L) gcd(b,a%b) else a
    
    fun solution(w: Int, h: Int): Long {

        var w = w.toLong()
        var h = h.toLong()
        
        w = if (w > h) w else h.also { h = w}

        return (w*h)-(w+h-gcd(w,h))
    }
}