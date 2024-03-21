fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val exist = mutableListOf<Char>()
    repeat(n) {
        val words = readLine().split(" ").toMutableList()

        var flag = false
        for (i in words.indices) {
            if (words[i][0].uppercaseChar() !in exist) {
                exist.add(words[i][0].uppercaseChar())
                flag = true
                words[i] = "[${words[i][0]}]${words[i].substring(1)}"
                println(words.joinToString(" "))
                break
            }
        }

        if (!flag) {
            for (i in words.indices) {
                var check = false
                for (j in words[i].indices) {
                    if (words[i][j].uppercaseChar() !in exist) {
                        exist.add(words[i][j].uppercaseChar())
                        flag = true
                        check = true
                        words[i] = words[i].substring(0, j) + "[${words[i][j]}]" + words[i].substring(j + 1)
                        println(words.joinToString(" "))
                        break
                    }
                }
                if (check) break
            }
        }

        if (!flag) {
            println(words.joinToString(" "))
        }
    }
}
