fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    val matrix = Array(n) { readLine().split(" ").map { it.toInt() } }
    val value = minOf(n, m)
    val cnt = if (value % 2 != 0) value / 2 + 1 else value / 2
    val tmp = Array(cnt) { mutableListOf<Int>() }

    var x = 0
    var y = m - 1
    var ss = 0
    repeat(cnt) { idx ->
        for (i in x until y + 1) {
            tmp[x].add(matrix[x][i])
            ss++
        }
        for (i in x + 1 until n - x) {
            tmp[x].add(matrix[i][y])
            ss++
        }

        for (i in y - 1 downTo x) {
            tmp[x].add(matrix[n - x - 1][i])
        }

        for (i in n - x - 2 downTo x + 1) {
            tmp[x].add(matrix[i][idx])
        }
        x++
        y--
    }

    repeat(r) {
        repeat(cnt) { idx ->
            val num = tmp[idx].removeFirst()
            tmp[idx].add(num)
        }
    }
    val result = Array(n) { IntArray(m) }

    repeat(cnt) { idx ->
        var tn = n - idx
        var tm = m - idx
        var t = 0
        var r = idx
        var c = idx
        for (i in 0 until tmp[idx].size) {
            result[r][c] = tmp[idx][i]
            if (t == 0) {
                c++
                if (c % (tm - 1) == 0) {
                    t++
                    continue
                }
            }

            if (t == 1) {
                r++
                if (r % (tn - 1) == 0) {
                    t++
                    continue
                }
            }

            if (t == 2) {
                c--
                if (c == idx) {
                    t++
                    continue
                }
            }

            if (t == 3) {
                r--
                if (r == idx) {
                    t++
                    continue
                }
            }
        }
    }

    result.forEach {
        println(it.joinToString(" "))
    }
}
