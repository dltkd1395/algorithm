
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val switch = readLine().split(" ").map { it.toInt() }.toIntArray()
    val m = readLine().toInt()

    repeat(m) {
        val (s, num) = readLine().split(" ").map { it.toInt() }
        if (s == 1) {
            for (i in num - 1 until n step num) {
                switch[i] = if (switch[i] == 1) 0 else 1
            }
        } else {
            switch[num - 1] = if (switch[num - 1] == 0) 1 else 0
            var left = num - 2
            var right = num
            while (left >= 0 && right < n) {
                if (switch[left] == switch[right]) {
                    switch[left] = if (switch[left] == 0) 1 else 0
                    switch[right] = if (switch[right] == 0) 1 else 0
                } else {
                    break
                }
                left-=1
                right+=1
            }
        }
    }
    for (i in 0 until switch.size) {
        if (i % 20 == 0 && i > 0) {
            println()
        }
        print("${switch[i]} ")
    }
}
