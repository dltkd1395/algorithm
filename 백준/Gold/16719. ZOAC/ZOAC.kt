fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    fun solve(strs: CharArray, s: Int, e: Int) {
        var minChar = 'Z' + 1
        var minIdx = -1
        for (i in s until e) {
            if (minChar > str[i]) {
                minIdx = i
                minChar = str[i]
            }
        }

        if (minIdx != -1) {
            strs[minIdx] = minChar
            for (i in strs.indices) {
                print("${if (strs[i].isLetter()) strs[i] else ""}")
            }
            println()
            solve(strs, minIdx + 1, e)
            solve(strs, s, minIdx)
        }
    }
    solve(CharArray(str.length), 0, str.length)
}