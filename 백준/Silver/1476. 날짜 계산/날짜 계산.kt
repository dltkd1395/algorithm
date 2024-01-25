fun main() {
    val (e, s, m) = readln().split(" ").map { it.toInt() }
    var (earth, sun, moon, result) = listOf(1, 1, 1, 1)
    while (e != earth || s != sun || m != moon) {
        earth = if ((earth + 1) % 16 == 0) 1 else earth + 1
        sun = if ((sun + 1) % 29 == 0) 1 else sun + 1
        moon = if ((moon + 1) % 20 == 0) 1 else moon + 1
        result++
    }
    println(result)
}