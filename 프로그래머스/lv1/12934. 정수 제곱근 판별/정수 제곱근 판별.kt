import kotlin.math.*

class Solution {
    fun solution(n: Long): Long {
     
        val sqrtValue = sqrt(n.toDouble())

        return if (sqrtValue == sqrtValue.toInt().toDouble()) (sqrtValue+1).pow(2.0).toLong() else -1
    }
}