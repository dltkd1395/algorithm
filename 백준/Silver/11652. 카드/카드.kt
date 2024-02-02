import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val numbers = mutableListOf<Long>()
    repeat(n) {
        numbers.add(readLine().toLong())
    }

    val result = numbers.groupingBy { it }
        .eachCount()
        .entries
        .sortedWith(compareByDescending<Map.Entry<Long, Int>> { it.value }.thenBy { it.key })
        .first()
        .key
    println(result)
}
