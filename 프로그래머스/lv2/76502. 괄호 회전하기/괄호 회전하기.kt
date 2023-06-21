class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val bracket = mapOf("}" to "{", 
                            "]" to "[", 
                            ")" to "("
                           )
        var s = s.map(Char::toString).toMutableList()
        val n = s.size
        
        for (i in 0 until n) {
            val stack = mutableListOf<String>()
            
            if (s.first() == "}" && s.first() == "]" && s.first() == ")" ) continue
            val tmp = s.toMutableList()
            for (j in 0 until n) {
                val b = s.removeFirst()
                if (stack.isEmpty()) {
                    stack.add(b)
                } else {
                    if (stack.last() != bracket[b]) {
                        stack.add(b)
                    } else {
                        stack.removeLast()
                    }
                }
            }
            tmp.add(tmp.removeFirst())
            s = tmp
            if (stack.isEmpty()) answer++
        }
        
        
        return answer
    }
}