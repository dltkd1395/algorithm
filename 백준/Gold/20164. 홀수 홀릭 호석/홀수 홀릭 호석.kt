fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine()

    var minValue = Int.MAX_VALUE
    var maxValue = Int.MIN_VALUE
    fun countOdd(x: String): Int {
        var cnt = 0
        for (char in x) {
            if (char in "13579") {
                cnt++
            }
        }
        return cnt
    }

    fun findOdd(number: String, cnt: Int) {
        if (number.length == 1) {
            minValue = minOf(minValue, cnt + countOdd(number))
            maxValue = maxOf(maxValue, cnt + countOdd(number))
        } else if (number.length == 2) {
            findOdd(
                (number[0].digitToInt() + number[1].digitToInt()).toString(),
                cnt + countOdd(number),
            )
        } else {
            val cntOdd = countOdd(number)
            for (i in 1 until number.length - 1) {
                for (j in i + 1 until number.length) {
                    val a = number.substring(0, i).toInt()
                    val b = number.substring(i, j).toInt()
                    val c = number.substring(j).toInt()
                    findOdd((a + b + c).toString(), cnt + cntOdd)
                }
            }
        }
    }
    findOdd(n, 0)
    println("$minValue $maxValue")
}