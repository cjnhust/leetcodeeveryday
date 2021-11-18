package lc

/**
 * @Description TODO

 * @Date 2021/11/18 下午10:54
 * @Created by wangbin
 */

fun mx(nums: IntArray){

    var max = nums[0]

    var preMax = 1

    var preMin = 1



    for(i in 0 until  nums.size){
        if(nums[i] < 0){
            var temp = preMax

            preMax = preMin

            preMin = temp
        }

        preMax = Math.max(preMax * nums[i], nums[i])
        preMin = Math.min(preMin * nums[i], nums[i])
        max = Math.max(preMax,preMin)

    }


}