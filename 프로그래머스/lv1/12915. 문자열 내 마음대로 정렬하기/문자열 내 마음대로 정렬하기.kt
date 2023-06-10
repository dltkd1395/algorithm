class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.sorted()
            .sortedBy { it.get(n) }
            .toTypedArray()
    }
}