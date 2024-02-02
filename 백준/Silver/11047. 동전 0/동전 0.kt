fun main() = with(System.`in`.bufferedReader()) {
    var (n, k) = readLine().split(" ").map { it.toInt() }
    val coins = List(n) { readLine().toInt() }
        .sortedDescending()
        .toMutableList()
    var result = 0
    while (k > 0) {
        val coin = coins.removeFirst()
        if (k >= coin) {
            result += k / coin
            k %= coin
        }
    }
    println(result)
}
