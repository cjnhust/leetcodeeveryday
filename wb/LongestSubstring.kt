/**
 * @Description TODO

 * @Date 2021/10/21 下午11:14
 * @Created by wangbin
 */
class LongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        // 滑动窗口
        // abcabcbb
        var max = 0
        var left = 0
        val map = mutableMapOf<Char, Int>()

        for (i in s.indices) {
            if (map.containsKey(s.toCharArray()[i])) {
                val oldIndex = map.get(s.toCharArray()[i])
                if (oldIndex != null) {
                    left = (oldIndex + 1).coerceAtLeast(left)
                }
            }
            map[s.toCharArray()[i]] = i
            max = (i - left + 1).coerceAtLeast(max)
        }
        return max
    }

}