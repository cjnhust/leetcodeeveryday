class Solution {
    // f(x) = min(a[x-1],a[x+1])-a[x]
    // f(0) = 0
    // f(1) =  0
    // f(2) = 1
    // 
     
    public int trap(int[] height) {
        if(height.length<=1) return 0;
        int result = 0;
       Map<Integer,Integer> left = new HashMap<>();
       left.put(0,0);
       Map<Integer,Integer> right = new HashMap<>();
       right.put(height.length-1,0);
        for(int i = 1;i<height.length;i++){
            left.put(i,Math.max(left.getOrDefault(i-1,0),height[i-1]));
          
            // for(int j=i+1;j<height.length;j++){
            //     if(height[j]>=right.getOrDefault(i,0)){
            //         right.put(i,height[j]);
            //     }
            // }
            // for(int k=i-1;k>=0;k--){
            //     if(height[k]>=left.getOrDefault(i,0)){
            //         left.put(i,height[k]);
            //     }
            // }
        }
        for(int i=height.length-2;i>=0;i--){
            right.put(i,Math.max(right.getOrDefault(i+1,0),height[i+1]));
        }
        for(int i=1;i<height.length-1;i++){
            int f =  Math.min(left.get(i),right.get(i))-height[i];
            if(f>0) result+=f;
        }
        return result;

    }
}