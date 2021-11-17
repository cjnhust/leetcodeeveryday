class Solution {
    private int count = 0; 
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        findHelper(0,target,sum,nums);
        return count;
    }

    private void findHelper(int index,int target,int sum,int[] nums){
        if(index == nums.length ){
            if(sum == target){
                count++;
            }
        }else{
            findHelper(index+1,target,sum+nums[index],nums);
            findHelper(index+1,target,sum-nums[index],nums);
        }
    }
}
