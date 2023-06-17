class Solution {
    fun solution(s: String): Int {
        var answer = Int.MAX_VALUE
        val sLen = s.length
        
        if (sLen == 1) {
            return 1
        }
        
        (1..sLen/2).forEach { size -> 
            val idx = sLen%size
      
            val st = mutableListOf<String>()
            (0 until sLen-idx).step(size).forEach { i ->
                st.add(s.substring(i, i+size))
  
            }
            var stack = mutableListOf<String>()
            var str = ""
            while (st.isNotEmpty()) {
                val s = st.removeFirst()

                if (stack.isEmpty()) {
                    stack.add(s)
                } else {
                    if (stack.last() == s) {
                        stack.add(s)
                    } else {
                        if (stack.size > 1) {
                            str += stack.size.toString() + stack.last()
                        } else {
                            str += stack.last()
                        }
                        stack = mutableListOf(s)
                    }
                }
            }
            
            if (stack.isNotEmpty()) {
                if (stack.size > 1) {
                    str += stack.size.toString() + stack.last()
                } else {
                    str += stack.last()
                }
            }
            answer = minOf(answer, (str+s.substring(sLen-idx, sLen)).length)
        }
        
        return answer
    }
}