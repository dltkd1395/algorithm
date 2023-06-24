class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = -1
        val n = dungeons.size
        val dungeonsList = mutableListOf<String>()
        
        fun backtrack(tmp: String, check: BooleanArray) {
            
            if (tmp.length == n) {
                dungeonsList.add(tmp)
                return
            }
            
             for (i in 0 until n) {
                 if (!check[i]) {
                     check[i] = true
                     backtrack(tmp+i.toString(), check)
                     check[i] = false
                 }
             }
        }
        
        val check = BooleanArray(n)
        backtrack("", check)
        dungeonsList.map { it.map(Character::getNumericValue)}
            .forEach { dungeon ->
            var tmpK = k
            var cnt = 0
            for (d in dungeon) {
                val (x, y) = dungeons[d]
                
                if (tmpK >= x) {
                    tmpK-=y
                    cnt++
                } else {
                    break
                }
            }
            answer = maxOf(answer, cnt)
        }
        
        return answer
    }
}