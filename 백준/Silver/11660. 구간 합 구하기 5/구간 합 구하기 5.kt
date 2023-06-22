import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val matrix = Array(n + 1) { IntArray(n + 1) }

    for (i in 1 until n+1) {
        val numbers = IntArray(n + 1)
        val numTokens = StringTokenizer(br.readLine())

        for (j in 1 until n+1) {
            numbers[j] = numTokens.nextToken().toInt()
            matrix[i][j] = matrix[i][j-1] + numbers[j]
        }
    }

    for (j in 1 until n+1) {
        for (i in 2 until n+1) {
            matrix[i][j] += matrix[i-1][j]
        }
    }
    
    val output = StringBuilder()

    for (i in 0 until m) {
        val queryTokens = StringTokenizer(br.readLine())
        val x1 = queryTokens.nextToken().toInt()
        val y1 = queryTokens.nextToken().toInt()
        val x2 = queryTokens.nextToken().toInt()
        val y2 = queryTokens.nextToken().toInt()

        val result = matrix[x2][y2]-matrix[x1-1][y2]-matrix[x2][y1-1]+matrix[x1-1][y1-1]
        output.append("$result\n")
    }
    print(output)
}