class Solution {
    
    fun isCorrect(p: String): Boolean {
        
        val stack = mutableListOf<Char>()
        
        if (p[0] == ')') return false
        
        val tmp = p.map{it}.toMutableList()
        
        while (tmp.isNotEmpty()) {
            val s = tmp.removeFirst()
            if (s == '(') {
                stack.add(s)
            } else {
                if (stack.isEmpty()) return false
                stack.removeLast()
            }
        }
        return true
        
    }
    
    fun splitString(p: String): Pair<String,String> {
        val u = mutableListOf<Char>()
        val v = p.map{it}.toMutableList()
        while (v.isNotEmpty()) {
            u.add(v.removeFirst())
            if (u.count { it == '('} == u.count { it == ')'}) {
                break
            }
        }
        
        return Pair(u.joinToString(""), v.joinToString(""))
        
    }
    
    fun solve(w: String): String {
        var ans = ""
        if (w.isEmpty()) return ans
        
        val (u,v) = splitString(w)
        
        if (isCorrect(u)) {
            ans += u
            ans += solve(v)
        } else {
            var tmp = "(" + solve(v) + ")"

            
            tmp += u.substring(1, u.length-1)
                .map { if (it == ')') '(' else ')'}
                .joinToString("")
            ans+=tmp
        }
        return ans
    }
    
    fun solution(p: String): String {

        return solve(p)
    }
}