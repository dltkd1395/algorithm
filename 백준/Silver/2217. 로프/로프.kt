fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ropes = List(n) { readLine().toInt() }.sortedDescending()
    var result = 0
    ropes.forEachIndexed { i, rope ->
        result = maxOf(result, rope * (i + 1))
    }
    println(result)
}