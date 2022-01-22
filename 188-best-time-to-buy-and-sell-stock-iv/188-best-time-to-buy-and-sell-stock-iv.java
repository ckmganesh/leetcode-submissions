class Solution {
    public int maxProfit(int k, int[] prices) {
        int max=0;
        if(k>=prices.length/2){
            for(int i=1;i<prices.length;i++){
                if(prices[i]>prices[i-1]) max+=prices[i]-prices[i-1];
            }
            return max;
        }
        
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }
}