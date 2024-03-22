fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    repeat(n) {
        val str = readLine().toCharArray()
        nextPermutation(str)
        println(str.joinToString(""))
    }
}

fun nextPermutation(str: CharArray): Boolean {
    var i = str.size - 1

    while (i > 0 && str[i - 1] >= str[i]) {
        i--
    }

    if (i == 0) return false

    var j = str.size - 1
    while (str[i - 1] >= str[j]) {
        j--
    }

    str.swap(i - 1, j)

    var k = str.size - 1
    while (i < k) {
        str.swap(i++, k--)
    }

    return true
}

fun CharArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}