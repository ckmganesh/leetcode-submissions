class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n==0||nums==null){
            return 0;
        }
        int[][] dp =new int[n][n];
        for(int window=0;window<n;window++){
            for(int i=0;i+window<n;i++){
                int j = i+window;
                for(int k=i;k<=j;k++){
                    int leftmost = i==0?1:nums[i-1];
                    int rightmost = j==n-1?1:nums[j+1];
                    int leftsum = k==0?0:dp[i][k-1];
                    int rightsum = k==n-1?0:dp[k+1][j];
                    dp[i][j]=Math.max(dp[i][j],(leftmost*nums[k]*rightmost)+leftsum+rightsum);
                }
            }
        }
        return dp[0][n-1];
    }
}