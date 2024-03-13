import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    var (n, q) = readLine().split(" ").map { it.toInt() }
    
    val arr = readLine().split(" ").map { it.toInt() }.sorted()
    val prefixSum = MutableList(n + 1) { 0 }
    for (i in 1 until n + 1) {
        prefixSum[i] = prefixSum[i - 1] + arr[i - 1]
    }
    var l: Int
    var r: Int
    repeat(q) {
        with(StringTokenizer(readLine())) {
            l = nextToken().toInt()
            r = nextToken().toInt()
        }
        bw.write("${prefixSum[r] - prefixSum[l - 1]}\n")
    }
    bw.close()
}