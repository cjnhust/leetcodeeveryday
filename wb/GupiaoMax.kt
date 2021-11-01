/**
 * @Description TODO

 * @Date 2021/11/1 下午11:49
 * @Created by wangbin
 */


fun maxProfit(prices: IntArray): Int {

val length = prices.size

    val dp = Array(length){IntArray(2)}

    dp[0][0] = 0

    dp[0][1] = -prices[0]

    for( i in 0 until length){
        dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i])
        dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] -prices[i])
    }

    return dp[length - 1][0]
}