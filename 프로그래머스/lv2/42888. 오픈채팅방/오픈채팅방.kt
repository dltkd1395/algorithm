class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        val command = mutableListOf<Pair<String, String>>()
        val users = mutableMapOf<String, String>()
        record.map { it.split(" ")}.forEach {
            when (it[0]) {
                "Enter" -> {
                    command.add(Pair(it[1],"님이 들어왔습니다."))
                    users.put(it[1], it[2])
                }
                "Leave" -> {
                    command.add(Pair(it[1],"님이 나갔습니다."))
                }
                else -> {
                    users[it[1]] = it[2]
                }
            }
        }
        
        command.forEach {
            answer.add(users[it.first].plus(it.second))
        }
        
        return answer.toTypedArray()
    }
}