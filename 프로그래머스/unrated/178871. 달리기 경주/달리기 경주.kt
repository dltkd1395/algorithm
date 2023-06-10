class Solution {
    
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        
        
        val playerMap = mutableMapOf<String, Int>()
        val rankMap = mutableMapOf<Int, String>()
        
        for (i in 0 until players.size) {
            playerMap.put(players[i], i)
            rankMap.put(i, players[i])
        }
        
        for (calling in callings) {
            val idx = playerMap[calling] as Int
            val temp = rankMap[idx-1] as String
            rankMap[idx-1] = calling
            rankMap[idx] = temp
            playerMap[calling] = idx - 1
            playerMap[temp] = idx
        }
        
        return rankMap.values.toTypedArray()
    }
}