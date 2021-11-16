package com.example.lc

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

/**
 * @ClassName: minPath
 * @Description: //TODO
 * @Author: wangbin
 * @Date: 11/16/21
 */


fun main() {
    val tets = arrayOf(arrayOf(1,3,1).toIntArray(), arrayOf(1,5,1).toIntArray(), arrayOf(4,2,1).toIntArray())

    println(minPathSum(tets))
}

fun minPathSum(grid: Array<IntArray>): Int {


    // dp
    val dp : Array<IntArray> =Array(grid.size){
        IntArray(grid[0].size)
    }

    // 第一行第一列使用grid的值
    dp[0][0] = grid[0][0]

    var sum = dp[0][0]
    for(i in 1 until grid[0].size){
        dp[0][i] = sum + grid[0][i]
        sum = dp[0][i]
    }

    sum = dp[0][0]

    for(i in 1 until grid.size){
        dp[i][0] = sum + grid[i][0]
        sum = dp[i][0]
    }

    for (i in 1 until grid.size){
        for (j in 1 until grid[0].size){
            val topValue = dp[i-1][j]  + grid[i][j]
            val leftValue = dp[i][j-1] + grid[i][j]

            dp[i][j] = topValue.coerceAtMost(leftValue)
        }
    }


    return dp[grid.size - 1][grid[0].size  - 1]
}




