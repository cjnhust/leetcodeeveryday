class Solution {
  public int maxProfit(int[] prices) {
      if (prices == null || prices.length == 0) {
          return 0;
      }

      int length = prices.length;

      int[] leftMinArray = new int[length];
      int[] rightMaxArray = new int[length];

      leftMinArray[0] = prices[0];
      rightMaxArray[length - 1] = prices[length - 1];

      for (int i = 1; i < length; i++) {
          leftMinArray[i] = Math.min(prices[i], leftMinArray[i - 1]);
      }

      for (int i = length - 2; i >= 0; i--) {
          rightMaxArray[i] = Math.max(prices[i], rightMaxArray[i + 1]);
      }

      int result = 0; 
      for (int i = 0; i < length; i++) {
          result = Math.max(rightMaxArray[i] - leftMinArray[i], result);
      }
      return result;
  }
}