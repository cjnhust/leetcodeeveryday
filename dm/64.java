class Solution {
  public int minPathSum(int[][] grid) {
      // 动态规划

      int rowLength = grid.length;
      int columnLength = grid[0].length;
      int[][] dp = new int[rowLength][columnLength];

      dp[0][0] = grid[0][0];

      // 第一行
      for (int i = 1; i < rowLength; i++) {
          dp[i][0] = dp[i-1][0] + grid[i][0];
      }

      // 第一列
      for (int j = 1; j < columnLength; j++) {
          dp[0][j] = dp[0][j-1] + grid[0][j];
      }

      // 更新剩余的值
      for (int i = 1; i < rowLength; i++) {
          for (int j = 1; j < columnLength; j++) {
              dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
          }
      }

      return dp[rowLength-1][columnLength-1];
  }
}