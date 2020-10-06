class Solution {
    public int[] beautifulArray(int N) {
        List<Integer> result=new ArrayList();
        result.add(1);
        while(result.size()<N)
        {
            List<Integer> temp=new ArrayList();
            for(int i:result)
            {
                if(2*i-1<=N)
                    temp.add(2*i-1);
                
            }
             for(int i:result)
            {
                if(2*i<=N)
                    temp.add(2*i);
                
            }
            result=temp;
        }
       return result.stream().mapToInt(i->i).toArray();
        
    }
}