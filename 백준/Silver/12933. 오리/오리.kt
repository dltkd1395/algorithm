fun main() = with(System.`in`.bufferedReader()) {
    val sound = readLine().toMutableList()
    var ans = 0

    if (sound.first() != 'q' || sound.last() != 'k' || sound.size % 5 != 0) {
        println(-1)
        return
    }

    fun findQuack(start: Int) {
        val quack = "quack"
        var j = 0
        var newDuck = true
        for (i in start until sound.size) {
            if (sound[i] == quack[j % 5]) {
                if (sound[i] == 'k') {
                    if (newDuck) {
                        ans++
                        newDuck = false
                    }
                }
                sound[i] = '0'
                j++
            }
        }
    }

    for (i in 0 until sound.size) {
        if (sound[i] == 'q') {
            findQuack(i)
        }
    }
    println(if (ans == 0 || sound.any { it != '0' }) -1 else ans)
}
