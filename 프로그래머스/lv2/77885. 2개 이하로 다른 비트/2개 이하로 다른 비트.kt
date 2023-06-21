class Solution {
    fun solution(numbers: LongArray): LongArray {
        var answer = mutableListOf<Long>()
        
        numbers.forEach { num ->
            if (num%2==0L) {
                answer.add(num+1)
            } else {
                var bineary = num.toString(2)
                var idx = -1
                
                val remainder = bineary.length % 4
                val number = ("0".repeat(4-remainder) + bineary).map(Char::toString).toMutableList()
                
                for (i in number.size-1 downTo 0) {
                    if (number[i] == "0") {
                        idx = number.size-1-(i+1)
                        break
                    }
                }
              
                answer.add(num.toLong()+Math.pow(2.0,idx.toDouble()).toLong())
            }
        }
        
        return answer.toLongArray()
    }
}