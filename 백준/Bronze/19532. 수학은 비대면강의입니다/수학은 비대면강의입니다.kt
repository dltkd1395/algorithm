fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    val a = numbers[0]
    val b = numbers[1]
    val c = numbers[2]
    val d = numbers[3]
    val e = numbers[4]
    val f = numbers[5]
    (-999 until 1000).forEach { i ->
        (-999 until 1000).forEach { j ->
            if (a * i + b * j ==  c && d * i + e * j == f) {
                println("$i $j")
                return
            }
        }
    }
}
