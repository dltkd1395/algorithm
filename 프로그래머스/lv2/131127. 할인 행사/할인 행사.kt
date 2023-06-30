class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val wantMap = want.toList().zip(number.toList()).toMap().toMutableMap()
        val n = number.sum()
    
        
        val wantSortedMap = wantMap.toMap().toSortedMap()
        
        
        
        var discountMap = discount.slice(0 until n).groupingBy { it }.eachCount().toSortedMap().toMutableMap()

        
        var start = 0
        var end = n - 1
        
      
        while(true) {
            discountMap = discountMap.toSortedMap()
            if (wantSortedMap == discountMap) answer++
            var f1 = discount[start]
            if (!discountMap.containsKey(f1)) discountMap.put(f1, 0)
            discountMap[f1] = discountMap[f1]?.minus(1) 
            start++
            end++
            
            if (end == discount.size) {
                break
            }
            
            var f2 = discount[end]
            if (!discountMap.containsKey(f2)) discountMap.put(f2, 0)
            discountMap[f2] = discountMap[f2]?.plus(1)
            
            if (discountMap[f1] == 0) {
                discountMap.remove(f1)
            }
            
        } 

        return answer
    }
}