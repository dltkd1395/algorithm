fun main() {
    val n = readln().toInt()
    val abcd = Array(n) { IntArray(4) }
    for (i in 0 until n) {
        val st = readln().split(" ")
        for (j in 0 until 4) {
            abcd[i][j] = st[j].toInt()
        }
    }

    val ab = IntArray(n * n)
    val cd = IntArray(n * n)
    for (i in 0 until n) {
        for (j in 0 until n) {
            ab[i * n + j] = abcd[i][0] + abcd[j][1]
            cd[i * n + j] = abcd[i][2] + abcd[j][3]
        }
    }

    ab.sort()
    cd.sort()

    var abp = 0
    var cdp = n * n - 1
    var cnt = 0L
    while (abp < n * n && cdp > -1) {
        val abv = ab[abp]
        val cdv = cd[cdp]
        val res = abv + cdv

        when {
            res < 0 -> abp++
            res > 0 -> cdp--
            else -> {
                var xc = 0L
                var yc = 0L
                while (abp < n * n && ab[abp] == abv) {
                    abp++
                    xc++
                }
                while (cdp > -1 && cd[cdp] == cdv) {
                    cdp--
                    yc++
                }
                cnt += xc * yc
            }
        }
    }
    println(cnt)
}