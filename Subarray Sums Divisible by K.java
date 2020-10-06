class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int current_sum=0;
        int count=0;
        for(int i=0;i<A.length;i++)
        {
            current_sum+=A[i];
            int rem=current_sum%K;
            if(rem<0)
                rem+=K;
            if(map.containsKey(rem))
            {
                count+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}