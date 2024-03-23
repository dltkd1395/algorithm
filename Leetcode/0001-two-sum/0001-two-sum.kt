class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var left = 0
        var right = nums.size - 1
        data class Position(val idx: Int, val num: Int)
        val arr = mutableListOf<Position>()
        for (i in 0 until nums.size) {
            arr.add(Position(i, nums[i]))
        }
        arr.sortWith(compareBy({it.num}))
        println(arr)

        while (left <= right) {
            val (li, num1) = arr[left]
            val (ri, num2) = arr[right]
            if (num1 + num2 == target) {
                return intArrayOf(li, ri)
            }

            if (num1 + num2 <= target) {
                left++
            } else {
                right--
            }
        }

        return intArrayOf()
    }
}