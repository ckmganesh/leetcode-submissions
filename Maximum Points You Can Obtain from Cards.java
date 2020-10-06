class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int left[]=new int[k+1];
        int right[]= new int[k+1];
        left[0]=right[0]=0;
        for(int i=1;i<k+1;i++)
            left[i]+=left[i-1]+cardPoints[i-1];
        for(int i=1,j=n-1;i<k+1;i++,j--)
            right[i]+=right[i-1]+cardPoints[j];
        int sum=Integer.MIN_VALUE;
        for(int i=0,j=k;i<k+1;i++,j--)
        {
            sum=Math.max(sum,left[i]+right[j]);
        }
        return sum;
    }
}