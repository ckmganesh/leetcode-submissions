class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0,min=Integer.MAX_VALUE;
        for(int a:prices){
            min=Math.min(min,a);
            maxProfit = Math.max(maxProfit,a-min);
        }
        return maxProfit;
    }
}