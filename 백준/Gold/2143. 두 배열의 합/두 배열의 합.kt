
fun main() {
    val t = readln().toLong()
    val n = readln().toInt()
    val nList = readln().split(" ").map { it.toLong() }
    val m = readln().toInt()
    val mList = readln().split(" ").map { it.toLong() }

    val nSumList = getSumList(nList)
    val mSumList = getSumList(mList)
    mSumList.sort()
    var cnt = 0L
    nSumList.forEach { num ->
        val left = getUpperIndex(t - num, mSumList)
        val right = getLowerIndex(t - num, mSumList)
        cnt += right - left
    }
    println(cnt)
}

fun getSumList(nmList: List<Long>): MutableList<Long> {
    val sumList = mutableListOf<Long>()
    (nmList.indices).forEach { i ->
        var sum = 0L
        (i until nmList.size).forEach { j ->
            sum += nmList[j]
            sumList.add(sum)
        }
    }
    return sumList
}

fun getUpperIndex(target: Long, mList: List<Long>): Long {
    var start = 0
    var end = mList.size - 1
    while (start <= end) {
        val mid = (start + end) / 2
        when {
            mList[mid] >= target -> {
                end = mid - 1
            }

            else -> start = mid + 1
        }
    }
    return end.toLong()
}

fun getLowerIndex(target: Long, mList: List<Long>): Long {
    var start = 0
    var end = mList.size - 1

    while (start <= end) {
        val mid = (start + end) / 2
        when {
            mList[mid] <= target -> start = mid + 1
            else -> end = mid - 1
        }
    }
    return end.toLong()
}
