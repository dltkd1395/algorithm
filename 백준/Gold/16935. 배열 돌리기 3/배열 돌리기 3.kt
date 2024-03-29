fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val nums = readLine().split(" ").map { it.toInt() }

    fun moveNum1(arr: Array<IntArray>): Array<IntArray> {
        val n = arr.size
        val m = arr[0].size
        val tmp = Array(n) { IntArray(m) }
        for (r in 0 until n) {
            for (c in 0 until m) {
                tmp[n - r - 1][c] = arr[r][c]
            }
        }
        return tmp
    }

    fun moveNum2(arr: Array<IntArray>): Array<IntArray> {
        val n = arr.size
        val m = arr[0].size
        val tmp = Array(n) { IntArray(m) }
        for (r in 0 until n) {
            for (c in 0 until m) {
                tmp[r][m - c - 1] = arr[r][c]
            }
        }
        return tmp
    }

    fun moveNum3(arr: Array<IntArray>): Array<IntArray> {
        val n = arr.size
        val m = arr[0].size
        val tmp = Array(m) { IntArray(n) }
        for (r in 0 until n) {
            for (c in 0 until m) {
                tmp[c][n - r - 1] = arr[r][c]
            }
        }
        return tmp
    }

    fun moveNum4(arr: Array<IntArray>): Array<IntArray> {
        val n = arr.size
        val m = arr[0].size
        val tmp = Array(m) { IntArray(n) }
        for (r in 0 until n) {
            for (c in 0 until m) {
                tmp[m - 1 - c][r] = arr[r][c]
            }
        }
        return tmp
    }

    fun moveNum5(arr: Array<IntArray>): Array<IntArray> {
        val n = arr.size
        val m = arr[0].size
        val tmp = Array(n) { IntArray(m) }

        // 1번 -> 2번
        for (i in 0 until n / 2) {
            for (j in 0 until m / 2) {
                tmp[i][j + m / 2] = arr[i][j]
            }
        }

        // 2번 -> 3번
        for (i in 0 until n / 2) {
            for (j in m / 2 until m) {
                tmp[i + n / 2][j] = arr[i][j]
            }
        }

        // 3번 -> 4번
        for (i in n / 2 until n) {
            for (j in m / 2 until m) {
                tmp[i][j - m / 2] = arr[i][j]
            }
        }

        // 4번 -> 1번
        for (i in n / 2 until n) {
            for (j in 0 until m / 2) {
                tmp[i - n / 2][j] = arr[i][j]
            }
        }

        return tmp
    }

    fun moveNum6(arr: Array<IntArray>): Array<IntArray> {
        val n = arr.size
        val m = arr[0].size
        val tmp = Array(n) { IntArray(m) }

        // 1번 -> 4번
        for (i in 0 until n / 2) {
            for (j in 0 until m / 2) {
                tmp[i + n / 2][j] = arr[i][j]
            }
        }

        // 4번 -> 3번
        for (i in n / 2 until n) {
            for (j in 0 until m / 2) {
                tmp[i][j + m / 2] = arr[i][j]
            }
        }

        // 3번 -> 2번
        for (i in n / 2 until n) {
            for (j in m / 2 until m) {
                tmp[i - n / 2][j] = arr[i][j]
            }
        }

        // 2번 -> 1번
        for (i in 0 until n / 2) {
            for (j in m / 2 until m) {
                tmp[i][j - m / 2] = arr[i][j]
            }
        }

        return tmp
    }
    var result = arr
    nums.forEach { num ->
        result = when (num) {
            1 -> moveNum1(result)
            2 -> moveNum2(result)
            3 -> moveNum3(result)
            4 -> moveNum4(result)
            5 -> moveNum5(result)
            else -> moveNum6(result)
        }
    }
    result.forEach { println(it.joinToString(" "))}
}
