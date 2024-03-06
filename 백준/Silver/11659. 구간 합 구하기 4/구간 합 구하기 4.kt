fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val numbers = readLine().split(" ").map { it.toInt() }.toMutableList()
    (1 until numbers.size).forEach { index ->
        numbers[index] += numbers[index - 1]
    }

    repeat(m) {
        val (s, e) = readLine().split(" ").map { it.toInt() - 1 }
        if (s > 0) {
            println(numbers[e] - numbers[s - 1])
        } else {
            println(numbers[e])
        }
    }
}