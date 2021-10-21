class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            for(int f = 0;f<nums2.length;f++){
                       nums1[f] = nums2[f]; 
            }
        return;
        }
        if(n == 0) return;
        int i=0;
        int j = 0; 
        int k = 0;
        int[] nums3 = new int[m+n];
        while(i<m||j<n){
            if(i<m&&j<n){
                if(nums1[i]<nums2[j]){
                    nums3[k] = nums1[i]; 
                    i = i+1;
                    k = k+1;
                }else{
                    nums3[k] = nums2[j];
                    j++;
                    k++;
                }
            }else if(i<m){
                nums3[k] = nums1[i]; 
                i++;
                k++;
            } else if(j<n){
                nums3[k] = nums2[j];
                j++;
                k++;
            }
        }
        for(int c=0;c<nums3.length;c++){
            nums1[c] = nums3[c];
        }
    }
}