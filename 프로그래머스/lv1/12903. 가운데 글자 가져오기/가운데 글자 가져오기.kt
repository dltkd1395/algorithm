class Solution {
    fun solution(s: String): String {
        var answer = ""
        return if (s.length % 2 != 0) {
            s[s.length/2].toString() 
        }    
        else {
            s[s.length/2-1].toString().plus(s[s.length/2].toString())
        }
    }
}