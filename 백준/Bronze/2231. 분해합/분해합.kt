fun main() {
    val n = readln().toInt()

    (1..n).forEach { num ->
        var sum = num
        var tmp = num
        while (tmp > 0) {
            sum += tmp % 10
            tmp /= 10
        }
        if (sum == n) {
            println(num)
            return
        }
    }
    println(0)
}
