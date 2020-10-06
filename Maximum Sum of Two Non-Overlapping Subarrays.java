class Solution {
    int max=Integer.MIN_VALUE;
    int current_max=Integer.MIN_VALUE;
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        
        int a=calculate(A,L,M);
        int b=calculate(A,M,L);
        return Math.max(a,b);
        
    }
    int calculate(int[] A,int window1,int window2)
    {
          int max=Integer.MIN_VALUE;
          int current_max=Integer.MIN_VALUE;
         List<Integer> first=new ArrayList<Integer>();
        List<Integer> second=new ArrayList<Integer>();

       
    int window1left,window1right,window2left,window2right;
        for(int i=0;i<=A.length-window1-window2;i++)
        {
            window1left=i;
            window1right=i+window1;
            window2left=window1right;
            window2right=window2+window1+i;
            int a=subarray(A,window1left,window1right);
            int b=subarray(A,window2left,window2right);
            first.add(a);
            second.add(b);
            
        }
        for(int i=0;i<first.size();i++)
        {
            for(int j=i;j<second.size();j++)
            {
                current_max=first.get(i)+second.get(j);
                max=Math.max(max,current_max);
            }
        }
        return max;
    }
    public int subarray(int A[],int start,int end)
    {
        int sum=0;
        for(int i=start;i<end;i++)
        {
            sum+=A[i];
        }
        return sum;
    }
}