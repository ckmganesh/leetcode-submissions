class Solution {
    public int[] countBits(int num) {
        int[] dp=new int[num+1];
    
     dp[0]=0;
        if(num==0)
            return dp;
     dp[1]=1;
        if(num==1)
            return dp;
        for(int i=2;i<=num;i++)
        {
            if(i%2==0)
                dp[i]=dp[i/2];
            else
                dp[i]=dp[i/2]+1;
            
        }
        return dp;
        
    }
}