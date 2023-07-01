class Solution {
    fun solution(cards: IntArray): Int {

        val box = mutableListOf<MutableList<Int>>()
        
        (0 until cards.size).forEach {
            var target = cards[it] 
            var idx = target - 1
            var tmp = mutableListOf<Int>(target)
            while (true) {
                if (tmp.contains(cards[idx])) break
                tmp.add(cards[idx])
                idx = cards[idx] - 1
                
            }
            tmp.sort()
            if (!box.contains(tmp)) {
                box.add(tmp)
            }
        }
        val sortedBox = box.sortedByDescending { it.size }
      
        return if (sortedBox.size <=1) 0 else sortedBox[0].size * sortedBox[1].size
    }
}