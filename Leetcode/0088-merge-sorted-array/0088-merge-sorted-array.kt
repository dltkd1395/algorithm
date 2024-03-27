class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if (m + n > m) {
            for(i in m until m + n) {
                nums1[i] = nums2[i - m]   
            }
        }
        nums1.sort()
    }
}