class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val bridge = MutableList(bridge_length) { 0 }
        val truck_weights = truck_weights.toMutableList()
        var truckResult = 0
        val n = truck_weights.size
        
        while (truckResult < n) {
            answer++
            val truck = bridge.removeFirst()
            if (truck_weights.isNotEmpty()) {
                if (bridge.sum() + truck_weights.first() <= weight) {
                    bridge.add(truck_weights.removeFirst())
                } else {
                    bridge.add(0)
                }
            } else {
                bridge.add(0)
            }
            if (truck > 0) {
                truckResult++
            }
        }
        
        
        return answer
    }
}