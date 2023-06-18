class Solution {

    
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer = arrayListOf<String>()
        
        val order = mutableListOf<String>()
        
        fun combinations(n: Int, start: Int, st: String, menu: String) {
            if (st.length == n) {
                order.add(st)
                return
            }
            
            
            for (i in start until menu.length) {
                combinations(n, i+1, st.plus(menu[i]), menu)
            }
            
        }
        
        orders.forEach { menu -> 
            val tmp = menu.map{it}.sorted().joinToString("")
            course.forEach {
                combinations(it, 0, "", tmp)
            }
        }
        
        val menus = order.groupingBy{ it }
            .eachCount()
            .toList()
            .filter { it.second >= 2}
            .sortedBy { it.first.length }
            
        for (c in course) {
            var maxValue = 0
            for (m in menus) {
                if (m.first.length == c) { 
                    maxValue = maxOf(maxValue, m.second)
                }
            }
            
            for (m in menus) {
                if (m.first.length == c) {
                    if (maxValue == m.second) {
                        answer.add(m.first)
                    }
                }
            }
        }
        return answer.sorted()
            .toTypedArray()
    }
}