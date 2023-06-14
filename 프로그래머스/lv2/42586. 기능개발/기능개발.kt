class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {   
        val answer = mutableListOf<Int>()
        val jobList = mutableListOf<Int>()
        progresses.zip(speeds).forEach {
            var job = (100-it.first)/it.second
            val remains = (100-it.first)%it.second
            job = if (remains == 0 ) job else job + 1
            jobList.add(job)
        }
        
        val stack = mutableListOf<Int>()
        
        while (jobList.isNotEmpty()) {
            if (stack.isEmpty()) {
                stack.add(jobList.removeFirst())
            } else {
                val job = jobList.removeFirst()
                if (stack.last() >= job) {
                    stack.add(stack.last())
                } else {
                    stack.add(job)
                }
            }
        }
        

        return stack.groupingBy { it }
            .eachCount()
            .values
            .toIntArray()
    }
}