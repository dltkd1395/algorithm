class Solution {
    fun solution(number: String, k: Int): String {
        val stack = mutableListOf<Int>()
        val numbers = number.map(Character::getNumericValue).toMutableList()
        var kCount = k

        for (num in numbers) {
            while (kCount > 0 && stack.isNotEmpty() && stack.last() < num) {
                stack.removeLast()
                kCount--
            }
            stack.add(num)
        }

        return stack.subList(0, number.length - k).joinToString("")
    }
}