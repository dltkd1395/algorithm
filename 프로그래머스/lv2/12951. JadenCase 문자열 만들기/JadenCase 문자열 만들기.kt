class Solution {
    fun solution(s: String): String {
        var answer = ""
        
        answer = s[0].uppercase()
        val s = s.lowercase()
        
        for (i in 1 until s.length) {
            if (s[i-1] == ' ' && s[i].isLetter()) {
                answer+= s[i].uppercase()
            } else {
                answer += s[i]
            }
        }

        return answer
    }
}