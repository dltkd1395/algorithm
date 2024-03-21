fun main() = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val tree = Array(k) { mutableListOf<Int>() }
    fillTree(arr, tree)
    tree.forEach {
        println(it.joinToString(" "))
    }

}
fun fillTree(arr: List<Int>, tree: Array<MutableList<Int>>, level: Int = 0) {
    if (arr.isEmpty()) return

    val rootIndex = arr.size / 2
    tree[level].add(arr[rootIndex])

    fillTree(arr.subList(0, rootIndex), tree, level + 1)

    if (rootIndex + 1 < arr.size) {
        fillTree(arr.subList(rootIndex + 1, arr.size), tree, level + 1)
    }
}
