class Solution {
    
    val answer = mutableSetOf<Int>()
    
    fun isPrime(number: Int): Boolean {
        if (number <= 1) {
            return false
        }
        
        var i = 2
        while (i*i <= number) {
            if (number%i++ == 0 ) {
                return false
            }
        }
        return true
    }
    
    fun permutations(numbers: String, number: String, num: Int, check: BooleanArray) {
        
        if (num == 0) {
            if (isPrime(number.toInt())) {
               answer.add(number.toInt())
            }
            return
        }
        
        for (i in 0 until numbers.length) {
            if (check[i]) continue
            check[i] = true
            permutations(numbers, number.plus(numbers[i]), num-1, check)
            check[i] = false
        }
    }
    
    fun solution(numbers: String): Int {
     
        for (i in 1..numbers.length) {
            permutations(numbers, "",  i, BooleanArray(numbers.length+1) {false})
        }
        
        return answer.size
    }
}