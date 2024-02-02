fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val a = readLine().split(" ").map { it.toInt() }.sorted()
    val b = readLine().split(" ").map { it.toInt() }.sortedDescending()
    println(a.zip(b).sumOf { (x, y) -> x * y })
}
