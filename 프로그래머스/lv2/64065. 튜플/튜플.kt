class Solution {
    fun solution(s: String): IntArray {
        
        return s.split("},")
            .map { it.replace("{","").replace("}", "").split(",") }
            .sortedBy { it.size }
            .flatMap { it }
            .toSet()
            .map(String::toInt)
            .toIntArray()
    }
}