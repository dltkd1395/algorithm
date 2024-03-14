fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val matrix = List(n) { readLine().split(" ").map { it.toInt() } }
        val ans = List(2) { mutableListOf<Int>() }
        for (i in 0 until n) {
            ans[0].add(matrix[i].sum())
        }
        for (i in 0 until n) {
            var sum = 0
            for (j in 0 until n) {
                sum += matrix[j][i]
            }
            ans[1].add(sum)
        }

        repeat(m) {
            val (r1, c1, r2, c2, v) = readLine().split(" ").map { it.toInt() }

            for (i in r1 - 1 until r2) {
                ans[0][i] += (c2 - c1 + 1) * v
            }

            for (i in c1 - 1 until c2) {
                ans[1][i] += (r2 - r1 + 1) * v
            }
        }

        for (i in 0 until 2) {
            println(ans[i].joinToString(" "))
        }
    }
}
