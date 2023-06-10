class Solution {
    private val scoreMap = mutableMapOf<String, Int>()
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer: ArrayList<Int> = arrayListOf()
        
        for (i in 0 until name.size) {
            scoreMap.put(name[i], yearning[i])
        }
        
        for (p in photo) {
            var score = 0
            for (name in p) {
                if (scoreMap.containsKey(name)) {
                    score+=scoreMap[name] as Int
                }
            }
            answer.add(score)
        }
        
        
        return answer.toIntArray()
    }
}