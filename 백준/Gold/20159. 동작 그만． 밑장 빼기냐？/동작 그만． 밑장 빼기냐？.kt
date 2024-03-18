fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    var junghunOriginSum = 0
    for (i in 0 until n) {
        if (i % 2 == 0) {
            junghunOriginSum += arr[i]
        }
    }
    var ans = junghunOriginSum
    var junghunSum = junghunOriginSum

    for (i in n - 1 downTo 1 step 2) {
        junghunSum += arr[i]
        junghunSum -= arr[i - 1]
        ans = maxOf(ans, junghunSum)
    }

    junghunSum = junghunOriginSum
    for (i in n - 2 downTo 1 step 2) {
        junghunSum -= arr[i]
        junghunSum += arr[i - 1]
        ans = maxOf(ans, junghunSum)
    }

    println(ans)
}