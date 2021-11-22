package com.example.lc

/**
 * @ClassName: rob
 * @Description: //TODO
 * @Author: wangbin
 * @Date: 11/22/21
 */
fun rob(nums: IntArray): Int {


    val dp = IntArray(nums.size){
        0
    }

    if(nums.size == 1){
        return nums[0]
    }

    if(nums.size  == 2){
        return Math.max(nums[0],nums[1])
    }

    dp[0] = nums[0]
    dp[1] = Math.max(dp[0], nums[1])

    for (i in 2 until nums.size){
        dp[i] = Math.max(dp[i-2]+ nums[i], dp[i-1])
    }

    return dp[nums.size - 1]


}