package lc

/**
 * @Description TODO

 * @Date 2021/11/15 下午9:17
 * @Created by wangbin
 */

fun canJump(nums: IntArray): Boolean {
    nums?:return false

    var preJump = 0

    for(index in 0 until preJump){
        // 第i哥元素可以跳的最远距离
        val temp = index+ nums[index]
        // 更新最远距离
        preJump = preJump.coerceAtLeast(temp)

        if(preJump >= nums.size- 1){
            return true
        }
    }

    return false
}