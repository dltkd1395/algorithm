class Solution {
    fun solution(n: Int): Int {
        return (1..n/2).fold(n) { acc, v -> if (n%v==0) acc+v else acc }
    }
}