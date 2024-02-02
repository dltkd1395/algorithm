import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val tmp = readLine().split(" ")
    val n = tmp.first().toInt()
    val numbers = tmp.subList(1, tmp.size).toMutableList()
    while (numbers.size < n) {
        numbers.addAll(readLine().split(" ").filter { it.isNotEmpty() })
    }

    numbers.filter { it != "0" }
        .map { it.reversed().toLong() }
        .sorted()
        .forEach {
            println(it)
        }
}