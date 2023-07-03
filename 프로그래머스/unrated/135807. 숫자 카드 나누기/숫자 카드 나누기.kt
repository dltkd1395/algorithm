class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer = 0
        fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a
        
        if (arrayA.size == 1) {
            if (arrayA[0] != arrayB[0]) answer = maxOf(arrayA[0], arrayB[0])  
        } else {
            var gcdA = gcd(arrayA[0], arrayA[1])
            var gcdB = gcd(arrayB[0], arrayB[1])

            for (i in 2 until arrayA.size) {
                gcdA = gcd(gcdA, arrayA[i])
                gcdB = gcd(gcdB, arrayB[i])
            }

            var max1 = 0
            var max2 = 0
            if (gcdA != 1 && arrayB.all { it % gcdA != 0 }) max1 = gcdA
            if (gcdB != 1 && arrayA.all { it % gcdB != 0 }) max2 = gcdB
            answer = maxOf(max1, max2)
        }

        return answer
    }
}