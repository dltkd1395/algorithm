fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val target = readLine().toInt()

    val arr = Array(n) { IntArray(n) }
    var x = 0
    var y = 0
    val dx = arrayOf(1, 0, -1, 0)
    val dy = arrayOf(0, 1, 0, -1)
    var num = n * n
    var d = 0
    var rx = 0
    var ry = 0
    while (true) {
        if (num == target) {
            rx = x
            ry = y
        }
        arr[x][y] = num
        var nx = dx[d] + x
        var ny = dy[d] + y

        if (nx !in 0 until n || ny !in 0 until n) {
            d = (d + 1) % 4
            continue
        }
        if (arr[nx][ny] != 0) {
            d = (d + 1) % 4
            nx = dx[d] + x
            ny = dy[d] + y
        }
        if (arr[nx][ny] != 0) {
            break
        }
        x = nx
        y = ny
        num--
    }

    arr.forEach { println(it.joinToString(" ")) }
    println("${rx + 1} ${ry + 1}")
}
