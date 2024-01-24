fun main() {
    val people = List(9) { readln().toInt() }.sorted()
    val result = findSevenDwarves(people)
    println(result.joinToString("\n"))
}

private fun findSevenDwarves(people: List<Int>): List<Int> {
    val total = people.sum()
    val excessSum = total - 100

    for (i in 0 until people.size - 1) {
        for (j in i + 1 until people.size) {
            if (people[i] + people[j] == excessSum) {
                return people.filterIndexed { index, _ -> index != i && index != j }
            }
        }
    }
    return emptyList()
}