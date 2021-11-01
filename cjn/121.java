class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int max =0;
        Map<Integer,Integer> leftMin = new HashMap<>();
        leftMin.put(0,prices[0]);
        for(int i=1;i<prices.length;i++){
            leftMin.put(i,Math.min(leftMin.getOrDefault(i-1,0),prices[i-1]));
            max = Math.max(max,prices[i]-leftMin.get(i));
        }
        return max;

    }
}