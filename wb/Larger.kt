package com.example

/**
 * @ClassName: Solution
 * @Description: 下一个大点的字典序
 * @Author: wangbin
 * @Date: 10/26/21
 */


fun nextPermutation(nums: IntArray): Unit {
    val length = nums.size
    // 扩展函数
    fun IntArray.swap(index1: Int, index2: Int){
        val temp = this[index1]
        this[index1] = this[index2]
        this[index2] = temp
    }

    for (i in length-1 downTo 1){
        if(nums[i]> nums[i-1]){
            nums.sort(i)
            for(j in i until length){
                if(nums[j]>nums[i-1]){
                    nums.swap(j,i-1)
                    return
                }
            }
        }
    }

    return nums.sort()
}

