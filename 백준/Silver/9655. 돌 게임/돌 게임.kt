fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    if (n % 2 == 0) {
        println("CY")
    } else {
        println("SK")
    }
}
