class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices==null||prices.length==1)
        {
            return 0;
        }
        int[][] t=new int[3][prices.length];
        for(int i=1;i<3;i++)
        {    int maxdif=-prices[0];
            
            for(int j=1;j<prices.length;j++)
            {
               int max=0;
                for(int m=0;m<j;m++)
                {
                    max=Math.max(max,t[i-1][m]+prices[j]-prices[m]);
                }
                t[i][j]=Math.max(max,t[i][j-1]);
            }
        }
        return t[2][prices.length-1];
        
    }
}