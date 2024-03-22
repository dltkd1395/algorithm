fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val board = Array(n) { IntArray(n) }
    val student = mutableMapOf<Int, List<Int>>()
    repeat(n * n) {
        val s = readLine().split(" ").map { it.toInt() }
        student[s[0]] = s.subList(1, 5)
    }
    val dx = arrayOf(1, 0, 0, -1)
    val dy = arrayOf(0, 1, -1, 0)

    data class Student(val s: Int, val x: Int, val y: Int)

    fun findLiekSeatCount(likeStudent: List<Int>): Int {
        var maxCnt = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                var cnt = 0
                if (board[i][j] == 0) {
                    for (d in 0 until 4) {
                        val nx = dx[d] + i
                        val ny = dy[d] + j

                        if (nx in 0 until n && ny in 0 until n) {
                            if (likeStudent.contains(board[nx][ny])) {
                                cnt++
                            }
                        }
                    }
                }
                maxCnt = maxOf(maxCnt, cnt)
            }
        }
        return maxCnt
    }

    fun findMaxLikeSeat(st: Int, likeStudent: List<Int>, maxCnt: Int): List<Student> {
        val student = mutableListOf<Student>()
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (board[i][j] == 0) {
                    var cnt = 0
                    for (d in 0 until 4) {
                        val nx = dx[d] + i
                        val ny = dy[d] + j

                        if (nx in 0 until n && ny in 0 until n) {
                            if (likeStudent.contains(board[nx][ny])) {
                                cnt++
                            }
                        }
                    }
                    if (cnt == maxCnt) {
                        student.add(Student(st, i, j))
                    }
                }
            }
        }
        return student
    }

    student.keys.forEach { num ->
        val likeStudent = student[num] ?: emptyList()
        val students = mutableListOf<Student>()
    
        val cnt = findLiekSeatCount(likeStudent)
        val st = findMaxLikeSeat(num, likeStudent, cnt)
 
        if (st.size > 1) {
            var maxEmptyCnt = 0
            st.forEach { (num, x, y) ->
                var emptyCnt = 0
                for (d in 0 until 4) {
                    val nx = dx[d] + x
                    val ny = dy[d] + y
                    if (nx in 0 until n && ny in 0 until n) {
                        if (board[nx][ny] == 0) {
                            emptyCnt++
                        }
                    }
                }
                maxEmptyCnt = maxOf(maxEmptyCnt, emptyCnt)
            }
            val emptySeat = mutableListOf<Student>()
            st.forEach { (num, x, y) ->
                var emptyCnt = 0
                for (d in 0 until 4) {
                    val nx = dx[d] + x
                    val ny = dy[d] + y
                    if (nx in 0 until n && ny in 0 until n) {
                        if (board[nx][ny] == 0) {
                            emptyCnt++
                        }
                    }
                }
                if (emptyCnt == maxEmptyCnt) {
                    emptySeat.add(Student(num, x, y))
                }
            }
            if (emptySeat.size == 1) {
                val (num, x, y) = emptySeat.first()
                board[x][y] = num
            } else {
                val (num, x, y) = emptySeat.sortedWith(compareBy({ it.x }, { it.y })).first()
                board[x][y] = num
            }
        } else {
            val (num, x, y) = st.first()
            board[x][y] = num
        }
    }
    var result = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            var cnt = 0
            for (d in 0 until 4) {
                val nx = dx[d] + i
                val ny = dy[d] + j

                if (nx in 0 until n && ny in 0 until n) {
                    val likeStudent = student[board[i][j]] ?: emptyList()
                    if (likeStudent.contains(board[nx][ny])) {
                        cnt++
                    }
                }
            }
            when (cnt) {
                0 -> result
                1 -> result += 1
                2 -> result += 10
                3 -> result += 100
                else -> result += 1000
            }
        }
    }
    println(result)
}
