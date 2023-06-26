class Solution {
    
    
    fun solution(n: Int, info: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val check = IntArray(11) { 0 }
        var maxScore = -1
        data class Score(var target: IntArray, var score: Int)
        val result = mutableMapOf<Int, MutableSet<String>>()
        
        fun compareScore(tmp: IntArray): Int {
            var a = 0
            var b = 0
            
            info.zip(tmp).forEachIndexed { i, (first, second) ->
                if (first != 0 || second != 0) {
                    if (first > second) {
                        a += 10-i
                    } else {
                        b += 10-i
                    }
                }
            }
      
            if (a < b) {

                return b-a
            } 
            return -1
        }
        
        fun check(tmp: IntArray): Boolean {
            info.zip(tmp).forEachIndexed { i, (first, second) ->
                if (second > 0 && i != 10) {
                    if (first >= second) {
                        return false
                    }
                }
            }
            return true
        }
        
        fun dfs(num: Int, start: Int, tmp: IntArray) {

            if (tmp.sum() == n && check(tmp)) {
                val s = compareScore(tmp)
         
                val t = tmp.copyOf().joinToString("")
                
                if (result.isEmpty()) {
                    result.put(s, mutableSetOf(t))
                } else {
                    
                    if (result.containsKey(s)) {
                        result[s]?.add(t)
                    } else if (result.keys.first() < s) {
                        result.clear()
                        result.put(s, mutableSetOf(t))
                    }
                }
                return
            }
            
            for (i in start until 11) {
                if (tmp[i] <= info[i]) {
                    tmp[i] += 1
                    dfs(n-1,i, tmp)
                    tmp[i] -= 1
                }
            }
        }

        dfs(n, 0, check)
        
        
        if (result.containsKey(-1)) {
            return intArrayOf(-1)
        }
        
        result.forEach { (key,value) -> 
            val v = value.map { it. reversed() }.sortedDescending().map { it.reversed() }
            println(v)
            return v.first().map(Character::getNumericValue).toIntArray()
            
        }
        return answer
    }
}

