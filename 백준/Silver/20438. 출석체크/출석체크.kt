fun main() = with(System.`in`.bufferedReader()) {
    val (n, k, q, m) = readLine().split(" ").map { it.toInt() }
    val bw = System.out.bufferedWriter()
    val arr = readLine().split(" ").map { it.toInt() }
    val qr = readLine().split(" ").map { it.toInt() }
    val sleep = BooleanArray(n + 3) { false }
    val check = IntArray(n + 3) { 1 }

    for (i in arr) {
        sleep[i] = true
    }

    for (i in qr) {
        if (sleep[i]) continue

        for (j in i until n + 3 step i) {
            if (sleep[j]) continue
            check[j] = 0
        }
    }
    check[2] = 0
    for (i in 3 until n + 3) {
        check[i] += check[i - 1]
    }

    repeat(m) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        bw.write("${check[e] - check[s - 1]}\n")
    }
    bw.close()
}
