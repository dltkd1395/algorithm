fun main() = with(System.`in`.bufferedReader()) {
    val (h, w) = readLine().split(" ").map { it.toInt() }
    val block = readLine().split(" ").map { it.toInt() }
    var result = 0
    for (i in 1 until w - 1) {
        val left = block.subList(0, i).max()
        val right = block.subList(i + 1, w).max()
        val minBlcok = minOf(left, right)
        if (block[i] < minBlcok) {
            result += minBlcok - block[i]
        }
    }
    println(result)
}
