fun main() {
    val (n, m) = readln().split(" ").map { it.toLong() }
    val trees = readln().split(" ").map { it.toLong() }.sorted()
    println(findMaxHeight(trees, m))
}

fun findMaxHeight(trees: List<Long>, height: Long): Long {
    var start = 0L
    var end = trees.last()
    var result = 0L
    while (start <= end) {
        val mid = (start + end) / 2
        val totalHeights = trees.sumOf { tree -> if (tree - mid < 0) 0 else tree - mid }
        when {
            totalHeights >= height -> {
                result = maxOf(result, mid)
                start = mid + 1
            }
            else -> end = mid - 1
        }
    }
    return result
}
