/**
 * @Description TODO

 * @Date 2021/10/20 下午9:55
 * @Created by wangbin
 */
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {

        val result = mutableListOf<List<Int>>()

        if(nums.size < 3){
            return emptyList()
        }

        if(nums.size == 3){
            return if(nums[0]+ nums[1]+ nums[2] == 0){
                mutableListOf( mutableListOf(nums[0],nums[1], nums[2]))
            }else {
                emptyList()
            }
        }

        nums.sort()

        val sumFunc = {x: Int, y: Int, z: Int, array: IntArray -> array[x]+ array[y]+ array[z]}
        for(i in nums.indices){
            if(nums[i]>0){
                break
            }
            // 去重
            if(i > 0 && nums[i] == nums[i-1]) continue
            var left = i+1
            var right = nums.size -1

            while(left< right){
                val sum = sumFunc(i,left,right, nums)

                when {
                    sum < 0 -> left++
                    sum > 0 -> right--
                    else -> {
                        result.add(mutableListOf(nums[i], nums[left],nums[right]))
                        while(left < right && nums[left] == nums[left+1]){
                            left++
                        }
                        while(left< right && nums[right] == nums[right-1]){
                            right--
                        }
                        left++
                        right--
                    }
                }
            }
        }

        return result

    }
}