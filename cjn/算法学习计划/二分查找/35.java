class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;
        while(left<=right){
            if(nums[mid]>target){
                right = mid-1;
                mid = (left+right)/2;
            }else if(nums[mid]<target){
                left = mid+1;
                mid = (left+right)/2;
            }else{
                return mid;
            }
        }
        if(target<nums[0]) return 0;
        return mid+1;

    }
}