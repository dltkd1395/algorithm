class Solution {
    fun solution(line: Array<IntArray>): Array<String> {
        var answer =  mutableListOf<String>()
        
        data class Point(val x: Double, val y: Double, val z: Double)
        val points = mutableSetOf<List<Long>>()
        
        fun getPoints(tmp: List<Point>): List<Double> {
            val (a,b,e) = tmp[0]
            val (c,d,f) = tmp[1]
            
            val denominator = ((a*d)-(b*c))
            
            if (denominator == 0.0 ) return listOf<Double>()
            
            val x = ((b*f)-(e*d)) / denominator
            val y = ((e*c)-(a*f)) / denominator
            
            return listOf(x,y)
        }
        var minX = Long.MAX_VALUE
        var maxX = -Long.MAX_VALUE
        var minY = Long.MAX_VALUE
        var maxY = -Long.MAX_VALUE
        
        fun backtracking(start: Int, check: BooleanArray, tmp: MutableList<Point>) {
            
            if (tmp.size == 2) {
                val point = getPoints(tmp)
                if (point.isEmpty()) return
                if (point[0]%1 == 0.0 && point[1]%1 == 0.0) {
                    val p = point.map(Double::toLong)
                    points.add(listOf(p[0], p[1]))
                    minX = minOf(minX, p[0])
                    minY = minOf(minY, p[1])
                    maxX = maxOf(maxX, p[0])
                    maxY = maxOf(maxY, p[1])
                }
                return
            }
            
            for (i in start until line.size) {
                if (!check[i]) {
                    val t = tmp.toMutableList()
                    check[i] = true
                    val (x,y,z) = line[i]
                    t.add(Point(x.toDouble(), y.toDouble(), z.toDouble()))
                    backtracking(i, check, t)
                    check[i] = false
                }
            }
        }
        
        val check = BooleanArray(line.size)
        backtracking(0, check, mutableListOf<Point>())
        
        val star = mutableListOf<String>()
        
        for (i in 0 until maxY - minY + 1L) {
            var s = ""
            for (j in 0 until maxX - minX + 1L) {
                s+="."
            }
            star.add(s)
        }
        
        points.forEach { point ->
            val (x,y) = point
            star[(maxY-y).toInt()] = star[(maxY-y).toInt()].substring(0,(x-minX).toInt())+"*"+star[(maxY-y).toInt()].substring((x-minX+1L).toInt(), star[(maxY-y).toInt()].length)
        }
        
        star.forEach {
            answer.add(it)
        }
        
        return answer.toTypedArray()
    }
}