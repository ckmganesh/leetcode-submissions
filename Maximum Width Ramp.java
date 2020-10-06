class Solution {
    public int maxWidthRamp(int[] A) {
        int n=A.length;
        int[] max=new int[A.length];
        int[] min=new int[A.length];
        min[0]=A[0];
        max[n-1]=A[n-1];
        for(int i=1;i<n;i++)
            min[i]=Math.min(min[i-1],A[i]);
        for(int i=n-2;i>=0;i--)
            max[i]=Math.max(max[i+1],A[i]);
        int right=0,left=0;
        int max_width=0;
        while(right<n&&left<n)
        {
            if(min[left]<=max[right])
            {
                max_width=Math.max(max_width,right-left);
                right++;
            }
            else
            {
                left++;
            }
        }
        return max_width;
}
}