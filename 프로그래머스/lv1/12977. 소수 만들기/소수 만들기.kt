class Solution {
    
    val numbers = mutableListOf<Int>()
    val answers = mutableListOf<Int>()
    
    fun isPrime(num: Int): Boolean {
       
        (2..num/2).forEach {
            if (num%it == 0) {
                return false
            }
        }
        return true
    }
    
    fun combinations(arr: IntArray, cnt: Int = 0, depth: Int = 3, start: Int = 0) {
        if (cnt == depth) {
            if (isPrime(numbers.sum())) {
                answers.add(numbers.sum())
            }
            return
        }
        
        for (i in start until arr.size) {
            numbers.add(arr[i])
            combinations(arr, cnt + 1, depth, i + 1)
            numbers.removeLast()
        }
    }
    
    fun solution(nums: IntArray): Int {
        combinations(nums)
        return answers.size
    }
}