class Solution {
    
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        
        val info = info.map { it.split(" ") }
        val queries = query.map { it.split(" and "," ") }
        
        val hm = HashMap<String, MutableList<Int>>()
        
        
        fun dfs(idx: Int, info: MutableList<String>, start: Int) {
         
            if (start == 4) {
                val q = info.subList(0,4).joinToString("")
                val s = info[4].toInt()
                if (hm.containsKey(q)) {
                    hm[q]?.add(s)
                } else {
                    hm[q] = mutableListOf(s)
                }
                return
            }
            
            
            val tmp = info[start]
            info[start] = "-"
            dfs(idx, info, start+1)
            info[start] = tmp
            dfs(idx, info, start+1)
        }
        
        fun search(key:String, score:Int): Int {
            if (!hm.containsKey(key)) return 0
            
            var start = 0
            var end = hm[key]!!.size - 1
            
            while (start<=end) {
                val mid = (start+end)/2
                
                if (hm[key]!![mid] < score) start = mid+1
                else end = mid - 1
            }
            return hm[key]!!.size - start
        }
        
        
        info.forEachIndexed { i, v ->
            dfs(i, v.toMutableList(), 0)
        }
        hm.values.forEach{ it.sort() }
        
        queries.forEach {
            val q = it.subList(0,4).joinToString("")
            val s = it[4].toInt()

            answer.add(search(q,s))
        }
        
        return answer.toIntArray()
    }
    
    
}