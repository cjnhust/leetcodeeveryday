class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null||nums.length<=1) return;
        int n = nums.length;
        int j = n-1;
        int i = n-2;
        //先从后往前找第一对相邻升序对(i,j)
        while(i>=0 && nums[i]>=nums[j]){
            i--;
            j--;
        }
        if(i>=0){
         //找到后如果i在数组内 那么从后往前找第一个比nums[i]大的数 交换两者的位置 此时肯定从j到n 都是降序的
        int k = n-1;
        while(k>=0&&nums[i]>=nums[k]){
            k--;
        }
           swap(nums,i,k);
        }
        //将降序的部分改成升序的从j到n,这样小数在高位字典序最小
        reverse(nums,j);
    }


    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums,int start){
        int n = nums.length;
        int i = 0;
        while(start+i<=n-i-1){
            swap(nums,start+i,n-1-i);
            i++;
        }
    }
}
