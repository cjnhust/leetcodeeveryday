class Solution {
    public int[] sortedSquares(int[] nums) {
       int[] result = new int[nums.length];
       int i = 0;
       int j = nums.length-1;
       int pos = nums.length-1;
       while(pos>=0){
           if(nums[i]*nums[i]>nums[j]*nums[j]){
               result[pos] = nums[i]*nums[i];
               i++;
           }else{
               result[pos] = nums[j]*nums[j];
               j--;
           }
           pos--;
       }
       return result;

    }
}
// 可以排序也可以用双指针