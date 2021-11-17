class Solution {
  // 问题转化
  // 设数组总和为sum，设需要添加-的数字和为n
  // (sum - n) + (-n) = target => sum - 2n = target
  // n = (sum - target) / 2
  // 由于nums为整数数组，则sum - target必须满足非负数且为偶数
  // 问题转化为从数组nums中寻找数字和等于n
  public int findTargetSumWays(int[] nums, int target) {
      int sum = 0;
      for (int num : nums) {
          sum += num;
      }

      int diff = sum - target;
      if (diff < 0 || diff % 2 != 0) {
          return 0;
      }

      int negative = diff / 2;
      int length = nums.length;

      // dp[i][j]代表在数组前i个元素中找到的和为j的组合数量
      int[][] dp = new int[length + 1][negative + 1];

      dp[0][0] = 1;

      for (int i = 1; i <= length; i++) {
          int num = nums[i - 1];
          for (int j = 0; j <= negative; j++) {
              if (num > j) {
                  dp[i][j] = dp[i-1][j];
              } else {
                  dp[i][j] = dp[i-1][j] + dp[i-1][j-num];
              }
          }
      }
      return dp[length][negative];
  }
}