class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m==0 && n == 0) return 0;
        if(m == 0) return n%2==0?(nums2[n/2-1]+nums2[n/2])/2f:nums2[n/2];
        if(n == 0) return m%2==0?(nums1[m/2-1]+nums1[m/2])/2f:nums1[m/2];
        int j = 0;
        int k =0;
        int i =0;
        int[] nums3 = new int[m+n];
        while(j<m||k<n){
            if(j<m&&k<n){
                if(nums1[j]<=nums2[k]){
                nums3[i] = nums1[j];
                i++;
                j++;
                }else{
                nums3[i] = nums2[k];
                i++;
                k++;
                }
            }else if(j<m){
                 nums3[i] = nums1[j];
                i++;
                j++;
            }else if(k<n){
 nums3[i] = nums2[k];
                i++;
                k++;
            }
        }
        if((m+n)%2!=0) {
           return nums3[(m+n)/2];
        }
        else{
             return (nums3[(m+n)/2-1]+nums3[(m+n)/2])/2f; }

    }
}
