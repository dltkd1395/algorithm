import java.util.StringTokenizer

lateinit var S: String
var q: Int = 0
val DP = Array(200002) { IntArray(26) }

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    S = readLine()
    q = readLine().toInt()
    // 각 알파벳 문자열에 대한 누적합 구하기
    for (i in 0..25) {
        for (j in 1..S.length) {
            DP[j][i] = if (S[j - 1] == 'a' + i) DP[j - 1][i] + 1 else DP[j - 1][i]
        }
    }
    // 질문 값 저장 및 함수 실행하여 결과 BufferedWriter 저장
    repeat(q) {
        val st = StringTokenizer(readLine(), " ")
        val alphabet = st.nextToken()[0] - 'a'
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        bw.write("${cal(alphabet, start, end)}\n")
    }

    bw.flush()
    bw.close()
    close()
}

fun cal(alphabet: Int, start: Int, end: Int): Int {
    return if (start == 0) DP[end + 1][alphabet] else DP[end + 1][alphabet] - DP[start][alphabet]
}
