import kotlin.math.abs

class Solution {
    
    val operators = mutableSetOf<String>()
    
    fun dfs(operator: List<Char>, check: BooleanArray, start: Int, cnt: Int, oper: String) {
        
        if (cnt == operator.size) {
            operators.add(oper)
            return
        }
        
        for (i in 0 until operator.size) {
            if (!check[i]) {
                check[i] = true
                dfs(operator, check, i, cnt+1, oper.plus(operator[i]))
                check[i] = false
                
            }
        }
    }
    
    

    fun solution(expression: String): Long {
        var answer: Long = 0
        
        val e = expression.map {it}.filter { it in listOf('+','-','*')}.toSet().toList()
        dfs(e, BooleanArray(3) { false}, 0, 0, "")
     
        val expressionList = mutableListOf<String>()
        var num = ""
        expression.forEach {
            if (it.isDigit()) {
                num+=it
            } else {
                expressionList.add(num)
                expressionList.add(it.toString())
                num = ""
            }
        }
        expressionList.add(num)

        operators.forEach { oper ->
            val tmp = expressionList.toMutableList()

            oper.forEach { op ->
                
                while (tmp.contains(op.toString())) {
                    val idx = tmp.indexOf(op.toString())
                    val result = when (op) {
                        '+' -> tmp[idx-1].toLong() + tmp[idx+1].toLong()
                        '-' -> tmp[idx-1].toLong() - tmp[idx+1].toLong()
                        else -> tmp[idx-1].toLong() * tmp[idx+1].toLong()
                    }
            
                    repeat(3) {
                        tmp.removeAt(idx-1)
                    }

                    tmp.add(idx-1, result.toString())

                }
            }
            answer = maxOf(answer, abs(tmp.first().toLong()))
        }
        
        return answer
    }
}