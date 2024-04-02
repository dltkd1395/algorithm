fun main() = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    val n = readLine().toInt()

    val original = Array(k) { (it + 65).toChar() }
    val converted = readLine().trim().toCharArray().toTypedArray()

    fun inputProcess(): Pair<List<String>, List<String>> {
        var flag = false
        val originalCommands = mutableListOf<String>()
        val convertedCommands = mutableListOf<String>()

        repeat(n) {
            val command = readLine()
            if (command[0] == '?') {
                flag = true
            } else if (flag) {
                convertedCommands.add(command)
            } else {
                originalCommands.add(command)
            }
        }

        return Pair(originalCommands, convertedCommands.reversed())
    }

    fun switch(lines: Array<Char>, commands: List<String>) {
        commands.forEach { command ->
            for (i in 0 until k - 1) {
                if (command[i] == '-') {
                    val temp = lines[i]
                    lines[i] = lines[i + 1]
                    lines[i + 1] = temp
                }
            }
        }
    }

    fun makeCommand(original: Array<Char>, converted: Array<Char>): String {
        var result = ""
        for (i in 0 until k - 1) {
            if (original[i] == converted[i + 1] && original[i + 1] == converted[i]) {
                result += '-'
            } else {
                result += '*'
            }
        }

        val test = original.copyOf()
        switch(test, listOf(result))

        return if (test.contentEquals(converted)) result else "x".repeat(k - 1)
    }

    fun solve() {
        val (originalCommands, convertedCommands) = inputProcess()
        switch(original, originalCommands)
        switch(converted, convertedCommands)

        val result = makeCommand(original, converted)
        println(result)
    }

    solve()
}
