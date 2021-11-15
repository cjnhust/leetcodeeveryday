class Solution {
  public boolean canJump(int[] nums) {
      int length = nums.length;
      int maxRight = 0; // 代表能够到达的最远位置（数组索引）
      for (int i = 0; i < length; i++) {
          if (i <= maxRight) {
              maxRight = Math.max(maxRight, i + nums[i]);
              if (maxRight >= length - 1) {
                  return true;
              }
          }
      }
      return false;
  }
}