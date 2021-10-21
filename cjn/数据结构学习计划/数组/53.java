class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max =nums[0];
        int pre = 0;
        // f[n] 为以n结尾的最大子序列和
        // f[n] = if(f[n-1]+nums[n]>f[n]) f[n] = nums[n]+f[n-1] else f[n]= f[n-1]
        // f[0] = nums[0]
        // f[n] = new int[len+1];
        // for(int i=1;i<len+1;i++){
         //   if(nums[i-1]+f[i-1]>nums[i-1]) f[i] = nums[i-1]+f[i-1]
          //  else f[i] = nums[i-1]
        // }
        for(int i=1;i<len+1;i++){
            int result = Math.max(nums[i-1], pre+nums[i-1]);
            pre = result;
            max = Math.max(max,result);
        }
        return max;

    }
}