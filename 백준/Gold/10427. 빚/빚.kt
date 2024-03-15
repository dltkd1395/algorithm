fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val input = readLine().split(" ").map { it.toInt() }
        val n = input[0]
        val money = input.drop(1).toMutableList()
        money.sort()

        var answer = 0L

        for (i in 2..n) {
            var sum = 0L
            for (j in 0 until i) {
                sum += money[j]
            }
            var min_value = money[i - 1].toLong() * i - sum
            for (j in i until n) {
                sum = sum + money[j] - money[j - i]
                min_value =
                    if (min_value < money[j].toLong() * i - sum) min_value else money[j].toLong() * i - sum
            }
            answer += min_value
        }

        println(answer)
    }
}