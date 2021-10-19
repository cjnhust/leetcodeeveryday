import java.util.*

/**
 * @Description TODO
 * @Date 2021/10/19 下午9:39
 * @Created by wangbin
 */
class MergeInterval {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        Arrays.sort(intervals) { a: IntArray, b: IntArray -> a[0] - b[0] }
        val res: MutableList<IntArray> = ArrayList()
        for (interval in intervals) {
            val left = interval[0]
            val right = interval[1]
            if (res.size == 0 || res[res.size - 1][1] < left)
                res.add(intArrayOf(left, right))
            else
                // 取大的值
                res[res.size - 1][1] = Math.max(res[res.size - 1][1], right)
        }
        return res.toTypedArray()
    }
}