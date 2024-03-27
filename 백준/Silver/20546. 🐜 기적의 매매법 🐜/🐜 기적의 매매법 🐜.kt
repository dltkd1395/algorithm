fun main() = with(System.`in`.bufferedReader()) {
    val money = readLine().toInt()

    val chart = readLine().split(" ").map { it.toInt() }

    var J = Pair(money, 0)
    var S = Pair(money, 0)
    var downCount = 0
    var upCount = 0

    for (i in chart.indices) {
        if (i != 0) {
            when {
                chart[i] > chart[i - 1] -> {
                    upCount++
                    downCount = 0
                }
                chart[i] == chart[i - 1] -> {
                    upCount = 0
                    downCount = 0
                }
                else -> {
                    downCount++
                    upCount = 0
                }
            }
        }

        if (J.first >= chart[i]) {
            J = J.copy(first = J.first - (J.first / chart[i] * chart[i]), second = J.second + (J.first / chart[i]))
        }

        if (downCount >= 3 && S.first >= chart[i]) {
            S = S.copy(first = S.first - (S.first / chart[i] * chart[i]), second = S.second + (S.first / chart[i]))
        }

        if (upCount >= 3 && S.second > 0) {
            S = S.copy(first = S.first + (S.second * chart[i]), second = 0)
        }
    }

    val JFinal = J.first + J.second * chart.last()
    val SFinal = S.first + S.second * chart.last()

    when {
        JFinal > SFinal -> println("BNP")
        JFinal < SFinal -> println("TIMING")
        else -> println("SAMESAME")
    }
}