class Solution {
    fun solution(word: String): Int {
        val alphabet = listOf('A','E','I','O','U')
        val dictionary = mutableListOf<String>()
        fun dfs(w: String) {
            dictionary.add(w)
            if (w.length == 5) {
                return
            }
            
            for (i in 0 until 5) {
                dfs(w+alphabet[i])
            }
        }
        dfs("")
        dictionary.sort()
        
        return dictionary.indexOf(word)
    }
}