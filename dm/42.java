class Solution {
  public int trap(int[] height) {
      if (height == null || height.length == 0) {
          return 0;
      }
      int n = height.length;
      
      int[] leftMaxArray = new int[n];
      leftMaxArray[0] = height[0];
      
      for (int i = 1; i < n; i++) {
          leftMaxArray[i] = Math.max(leftMaxArray[i - 1], height[i]);
      }
      
      int[] rightMaxArray = new int[n];
      rightMaxArray[n - 1] = height[n - 1];
      
      for(int i = n - 2; i >= 0; i--) {
          rightMaxArray[i] = Math.max(rightMaxArray[i + 1], height[i]);
      }        
      
      int total = 0;
      for (int i = 0; i < n; i++) {
          total += Math.min(leftMaxArray[i], rightMaxArray[i]) - height[i];
      }
      
      return total;
  }
}