fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var answer = 0
    repeat(n) {
        var alphabet = mutableMapOf<Char, Int>()
        val word = readLine()
        var isTrue = true
        alphabet[word[0]] = 1
        for (i in 1 until word.length) {
            if (alphabet.containsKey(word[i]) && word[i - 1] == word[i]) {
                continue
            }
            if (alphabet.containsKey(word[i]) && word[i - 1] != word[i]) {
                isTrue = false
                break
            }

            if (alphabet.containsKey(word[i]).not()) {
                alphabet[word[i]] = 1
            }
        }
        if (isTrue) answer++
    }
    println(answer)
}