class Solution {
    fun equalFrequency(word: String): Boolean {
        var answer = false
        
        for (i in 0 until word.length) {
            val left = word.substring(0, i)
            val right = word.substring(i+1, word.length)
            val str = left + right
            val cnt = str.groupingBy { it }.eachCount().values
            val minValue = cnt.min()
            if (cnt.all { it ==  minValue }) {
                return true
            }
        }

        return answer
    }
}