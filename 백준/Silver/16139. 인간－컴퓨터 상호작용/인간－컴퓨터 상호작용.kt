fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val str = readLine()
    val q = readLine().toInt()
    repeat(q) {
        var (alpha, l, r) = readLine().split(" ")
        val prefixSum = MutableList(str.length + 1) { 0 }
        for (i in 1 until str.length + 1) {
            prefixSum[i] = if (str[i - 1] == alpha.first()) {
                prefixSum[i - 1] + 1
            } else {
                prefixSum[i - 1]
            }
        }
        val left = l.toInt()
        val right = r.toInt()
        bw.write("${prefixSum[right + 1] - prefixSum[left]}\n")
    }
    bw.close()
}
