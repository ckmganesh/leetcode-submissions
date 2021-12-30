class Solution {
    Integer dp[];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length];
        return helper(0,arr,k);
    }
    int helper(int index,int arr[],int k){
        if(index>=arr.length) return 0;
        if(dp[index]!=null) return dp[index];
        int current=0,max=0;
        for(int j=0;j<k;j++){
            int to = index+j;
            if(to>=arr.length) break;
            current = Math.max(current,arr[to]);
            max=Math.max(current*(j+1)+helper(to+1,arr,k),max);
        }
        return dp[index]=max;
    }
}