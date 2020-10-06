class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        HashMap<Integer,Integer> freqa=new HashMap();
        HashMap<Integer,Integer> freqb=new HashMap();
        int max=Integer.MIN_VALUE;int value=0;
        if(A.length==1 && B.length==1)
           return 0;
     
       for(int i=0;i<A.length;i++)
       {freqa.put(A[i],freqa.getOrDefault(A[i],0)+1);
        freqb.put(B[i],freqb.getOrDefault(B[i],0)+1);
        if(freqa.get(A[i])>max)
        {
         max=  freqa.get(A[i]);
            value=A[i];
        }
        if(freqb.get(B[i])>max)
        {
           max= freqb.get(B[i]);
            value=B[i]; 
        }
       }
        for(int i=0;i<A.length;i++)
            if(A[i]!=value && B[i]!=value)
                return -1;
        return A.length-Math.max(freqa.get(value),freqb.get(value));
        
    }
}