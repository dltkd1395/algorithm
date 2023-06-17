class Solution {
    
    val answers = mutableListOf<Int>()
    
    fun dfs(numbers: IntArray, num: Int, target: Int, idx: Int) {
        
        if (idx == numbers.size) {
            if (num == target) {
                answers.add(num)
            }
            return
        }
        
        dfs(numbers, num+numbers[idx], target, idx+1)
        dfs(numbers, num-numbers[idx], target, idx+1)
          
    }
    
    fun solution(numbers: IntArray, target: Int): Int {
        
        dfs(numbers, 0, target, 0)
        return answers.size
    }
}