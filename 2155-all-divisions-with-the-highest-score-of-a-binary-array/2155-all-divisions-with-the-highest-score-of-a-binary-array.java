class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int ones[] = new int[nums.length];
        int zeros[] = new int[nums.length];
        if(nums[0]==0) zeros[0]=1;
          int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]==0) zeros[i]=zeros[i-1]+1;
            else zeros[i]=zeros[i-1];
        }
        ones[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--) ones[i]=ones[i+1]+nums[i];
        
        int result[] = new int[n+1];
        result[0]=ones[0];
        for(int i=0;i<n-1;i++)
            result[i+1]=zeros[i]+ones[i+1];
        result[n]=zeros[n-1];
        
        int max=result[0];
        for(int i=1;i<result.length;i++) max=Math.max(max,result[i]);
        
        List<Integer> ans = new ArrayList();
        for(int i=0;i<result.length;i++) if(result[i]==max) ans.add(i);
    
        return ans;
        
    }
}