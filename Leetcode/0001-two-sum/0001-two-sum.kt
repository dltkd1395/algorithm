class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var left = 0
        var right = 1

        while(left < right) {
            println("$left $right")
            if (nums[left] + nums[right] == target) {
                return intArrayOf(left, right)
            }
            if (left + 1 == right) {
                right++
            } else if (right == nums.size - 1) {
                left++
            } else {
                left++
            }
        }
        return intArrayOf()
    }
}