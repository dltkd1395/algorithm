fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val originalStr = mutableListOf<Char>()
    val reverseStr = mutableListOf<Char>()

    var index = 0
    var flag = false
    while(index < str.length) {
        if (str[index] == '<') {
            flag = true
            while (reverseStr.isNotEmpty()) {
                originalStr.add(reverseStr.removeLast())
            }
            originalStr.add(str[index])
        } else if (str[index] == '>') {
            flag = false
            originalStr.add(str[index])
        } else if (str[index] == ' '){
            while (reverseStr.isNotEmpty()) {
                originalStr.add(reverseStr.removeLast())
            }
            originalStr.add(' ')
        } else {
            if (flag) {
                originalStr.add(str[index])
            } else {
                reverseStr.add(str[index])
            }
        }
        index++
    }
    while (reverseStr.isNotEmpty()) {
        originalStr.add(reverseStr.removeLast())
    }
    println(originalStr.joinToString(""))
}

