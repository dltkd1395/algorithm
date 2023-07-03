class Solution {
    data class Point(val x: Double, val y: Double)

    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        val answer = mutableListOf<Double>()
        var x = 0
        val points = mutableListOf<Point>()
        var kValue = k

        while (kValue > 1) {
            points.add(Point(x.toDouble(), kValue.toDouble()))

            if (kValue % 2 == 0) {
                kValue /= 2
            } else {
                kValue = kValue * 3 + 1
            }

            x++
        }

        points.add(Point(x.toDouble(), kValue.toDouble()))

        val result = mutableListOf<Double>()

        fun getAreaValue() {
            for (i in 1 until points.size) {
                val (x1, y1) = points[i - 1]
                val (x2, y2) = points[i]

                val triangle = Math.abs(y1 - y2) * 0.5
                val square = if (y1 > y2) y2 else y1
                result.add(triangle + square)
            }
        }

        getAreaValue()

        val n = result.size

        ranges.forEach { (start, end) ->
            if (start > n + end) {
                answer.add(-1.0)
            } else {
                val total = result.subList(start, n + end.coerceAtMost(n)).sum()
                answer.add(total)
            }
        }

        return answer.toDoubleArray()
    }
}