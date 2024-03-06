fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val triangle = mutableListOf<MutableList<Int>>()
    repeat(n) {
        triangle.add(readLine().split(" ").map { it.toInt() }.toMutableList())
    }
    if (n > 1) {
        triangle[1] = triangle[1].map { it + triangle[0][0] }.toMutableList()
    }
    (2 until n).forEach { x ->
        (0 until triangle[x].size).forEach { y ->
            when (y) {
                0 -> {
                    triangle[x][0] += triangle[x - 1].first()
                }
                triangle[x].size - 1 -> {
                    triangle[triangle[x].size - 1][y] += triangle[x - 1].last()
                }
                else -> {
                    triangle[x][y] += maxOf(triangle[x - 1][y - 1], triangle[x - 1][y])
                }
            }
        }
    }
    println(triangle.last().max())
}