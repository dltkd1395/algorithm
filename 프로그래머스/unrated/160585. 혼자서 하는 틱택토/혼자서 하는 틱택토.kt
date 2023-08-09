class Solution {
    fun solution(board: Array<String>): Int {
        var answer: Int = -1
        var player1 = 0
        var player2 = 0
        var isWinPlayer1 = false
        var isWinPlayer2 = false
        var oCount = 0
        var xCount = 0
        
        var otmp = 0
        var xtmp = 0
        repeat(3) { row ->
            otmp = 0
            xtmp = 0
            repeat(3) { col -> 
                if (board[row][col] == 'O') {
                    oCount++
                    otmp++
                }
                if (board[row][col] == 'X') {
                    xCount++
                    xtmp++
                }
            }
            if (otmp == 3) isWinPlayer1 = true
            if (xtmp == 3) isWinPlayer2 = true
        }

        repeat(3) { col ->
            otmp = 0
            xtmp = 0
            repeat(3) { row -> 
                if (board[row][col] == 'O') otmp++
                if (board[row][col] == 'X') xtmp++
            }
            if (otmp == 3) isWinPlayer1 = true
            if (xtmp == 3) isWinPlayer2 = true
        }
        
        otmp = 0
        xtmp = 0
        
        repeat(3) { idx -> 
            if (board[idx][idx] == 'O') otmp++
            if (board[idx][idx] == 'X') xtmp++
        }
        
        if (otmp == 3) isWinPlayer1 = true
        if (xtmp == 3) isWinPlayer2 = true
        
        otmp = 0
        xtmp = 0
        
        repeat(3) { idx ->
            if (board[idx][3-idx-1] == 'O') otmp++
            if (board[idx][3-idx-1] == 'X') xtmp++
        }
        
        if (otmp == 3) isWinPlayer1 = true
        if (xtmp == 3) isWinPlayer2 = true
      
        return when {
            oCount - xCount > 1 -> 0
            oCount < xCount -> 0
            oCount > xCount && isWinPlayer2 -> 0
            oCount == xCount && isWinPlayer1 -> 0
            else -> 1
        }
    }
}