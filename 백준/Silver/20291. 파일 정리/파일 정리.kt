fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val files = mutableMapOf<String, Int>()
    repeat(n) {
        val (name, type) = readLine().split(".")
        if (files.containsKey(type)) {
            files[type] = files[type]?.plus(1) ?: 1
        } else {
            files[type] = 1
        }
    }
    files.entries.sortedBy { it.key }.forEach { (key, value) ->
        println("$key $value")
    }
}