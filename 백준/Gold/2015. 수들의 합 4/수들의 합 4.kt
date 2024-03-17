fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toLong() }
    val arr = readLine().split(" ").map { it.toLong() }
    val dict = mutableMapOf(0L to 1L)
    var sum = 0L
    var result = 0L

    for (i in arr) {
        sum += i
        if (sum - k in dict.keys) {
            result += dict[sum - k] ?: 0L
        }
        dict[sum] = dict.getOrDefault(sum, 0) + 1L
    }
    println(result)
}
