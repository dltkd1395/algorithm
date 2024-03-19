
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val trains = List(n) { ArrayDeque<Int>().apply { repeat(20) { add(0) } } }
    repeat(m) {
        val commands = readLine().split(" ").map { it.toInt() }
        when (commands[0]) {
            1 -> {
                val (_, t, s) = commands
                trains[t - 1][s - 1] = 1
            }

            2 -> {
                val (_, t, s) = commands
                trains[t - 1][s - 1] = 0
            }

            3 -> {
                val (_, t) = commands
                trains[t - 1].removeLast()
                trains[t - 1].addFirst(0)
            }

            else -> {
                val (_, t) = commands
                trains[t - 1].removeFirst()
                trains[t - 1].add(0)
            }
        }
    }
    val result =
        trains.map { it.joinToString("") }.toSet()
    println(result.size)
}