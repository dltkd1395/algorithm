class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        
        val parkingTime = mutableMapOf<String, Int>()
        var parkingTotalTime = mutableMapOf<String, Int>()
        val parkingFees = mutableMapOf<String, Double>()
        
        val (a,b,c,d) = fees
        records.forEach { record ->
            val (time, carNumber, status) = record.split(" ")
            val minute = time.split(":")
                .map(String::toInt)
                .let { it[0]*60+it[1] }
            
            when (status) {
                "IN" -> {
                    parkingTime[carNumber] = minute
                }
                "OUT" -> {
                    val totalTime = minute-parkingTime[carNumber] as Int
                    if (parkingTotalTime.containsKey(carNumber)) {
                        parkingTotalTime[carNumber] = parkingTotalTime[carNumber]!!.plus(totalTime)
                    } else {
                        parkingTotalTime[carNumber] = totalTime
                    }
                    parkingTime.remove(carNumber)
                }
            }
        }
        
        if (parkingTime.isNotEmpty()) {
            parkingTime.forEach { (key, value) ->
                val totalTime = 23*60+59-value as Int
              
                if (parkingTotalTime.containsKey(key)) {
                    parkingTotalTime[key] = parkingTotalTime[key]!!.plus(totalTime)
                } else {
                    parkingTotalTime[key] = totalTime
                }
            }
        }
        parkingTotalTime = parkingTotalTime.toSortedMap()
        parkingTotalTime.forEach { (key,value) -> 
  
            if (value > a) {
                answer.add((b + Math.ceil((value-a)/c.toDouble())*d).toInt())
            } else {
                answer.add(b)
            }
        }
        
        
        return answer.toIntArray()
    }
}