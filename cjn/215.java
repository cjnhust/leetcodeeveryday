class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        buildHeap(nums,n);
        int count = 1;
        int result= 0;
        for(int i=n-1;i>=0;i--){
            result = nums[0];
            if(k == count) return result;
            swap(nums,i,0);
            heapify(nums,i,0);
            count++;
        }
        return result;

    }

    private void heapify(int[] nums,int n,int i){
        if(i>=n) return;
        int max = i;
        int c1 = i*2+1;
        int c2 = i*2+2;
        if(c1<n&&nums[c1]>nums[max]){
            max = c1;
        }
        if(c2<n&&nums[c2]>nums[max]){
            max = c2;
        }
        if(max!=i){
            swap(nums,max,i);
            heapify(nums,n,max);
        }
    }

    private void buildHeap(int[] nums,int n){
        int last = n-1;
        int lastParent = (last-1)/2;
        for(int i=last;i>=0;i--){
            heapify(nums,n,i);
        }
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
