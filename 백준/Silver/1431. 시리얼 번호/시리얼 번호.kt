import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val serials = List(n) { readLine() }
        .sortedWith(
            compareBy(
                { serial -> serial.length },
                { serial ->
                    serial.filter { it.isDigit() }.sumOf { it.digitToInt() }
                },
                { it },
            ),
        )

    serials.forEach { println(it) }
}