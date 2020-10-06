class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int curr=A[0],max=Integer.MIN_VALUE;
        for(int i=1;i<A.length;i++)
        {
            max=Math.max(max,curr+A[i]-i);
            curr=Math.max(curr,A[i]+i);
            
            
        }
        return max;
    }
}