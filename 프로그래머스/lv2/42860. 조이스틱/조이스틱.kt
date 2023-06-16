class Solution {
    fun solution(name: String): Int {
        var answer = 0
        
       answer+= name.map { if ((it - 'A') < ('Z' - it + 1)) it - 'A' else 'Z' - it + 1 }.sum()
       
       val len = name.length 
       var move = len - 1
        name.forEachIndexed { i,v ->
            var cnt = i+1
            while (cnt < len && name[cnt] == 'A') {
                cnt++
            }
            move = minOf(move, i + (len-cnt) + minOf(i, len-cnt))
        }
        answer+=move
        
        return answer
    }
}