class Solution {
    fun solution(s: String, n: Int): String {
        return s.map { 
            val start = if (it.isLowerCase()) 'a' else 'A' 
            if (it.isLetter()) (start + (it - start + n)%26).toChar() else it 
        }.joinToString("")
    }
}