fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (d, n) = readLine().split(" ").map { it.toInt() }
        val arr = readLine().split(" ").map { it.toInt() }
        val mod = IntArray(d)
        var answer = 0

        var sum = 0
        for (num in arr) {
            sum = (sum + num) % d
            answer += mod[sum]
            mod[sum] += 1
            if (sum == 0) {
                answer++
            }
        }
        println(answer)
    }
}