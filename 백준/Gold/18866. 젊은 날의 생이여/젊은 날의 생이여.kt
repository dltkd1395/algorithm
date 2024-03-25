fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { IntArray(2) }
    
    for (i in 0 until n) {
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val young = Array(n) { IntArray(2) }
    val old = Array(n) { IntArray(2) }

    var youngMinHappy = Int.MAX_VALUE
    var youngMaxTired = 0
    var oldMaxHappy = 0
    var oldMinTired = Int.MAX_VALUE
    
    for (i in 0 until n) {
        if (arr[i][0] < youngMinHappy && arr[i][0] != 0) youngMinHappy = arr[i][0]
        if (arr[i][1] > youngMaxTired && arr[i][1] != 0) youngMaxTired = arr[i][1]

        young[i][0] = youngMinHappy
        young[i][1] = youngMaxTired
    }
    
    for (i in n - 1 downTo 0) {
        if (arr[i][0] > oldMaxHappy && arr[i][0] != 0) oldMaxHappy = arr[i][0]
        if (arr[i][1] < oldMinTired && arr[i][1] != 0) oldMinTired = arr[i][1]

        old[i][0] = oldMaxHappy
        old[i][1] = oldMinTired
    }

    var answer = -1
    for (i in 1 until n) {
        if (young[i - 1][0] > old[i][0] && young[i - 1][1] < old[i][1]) answer = i
    }

    println(answer)
}
