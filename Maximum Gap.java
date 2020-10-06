class Solution {
    class Bucket
    {
        boolean used=false;
        int max_value=Integer.MIN_VALUE;
        int min_value=Integer.MAX_VALUE;
        public Bucket()
        {
            used=false;
            max_value=Integer.MIN_VALUE;
            min_value=Integer.MAX_VALUE;
        }
        
    }
    public int maximumGap(int[] nums) {
        if(nums== null || nums.length==0 || nums.length<2)
        {
          return 0;
            
        }
        int max=Arrays.stream(nums).max().getAsInt();
        int min=Arrays.stream(nums).min().getAsInt();
        int capacity=Math.max(1,(max-min)/(nums.length-1));
        int buckets=(max-min)/(capacity) +1;
        Bucket[] b=new Bucket[buckets];
        for(int j=0;j<buckets;j++)
        {
            b[j]=new Bucket();
        }
        for(int i:nums)
        {
            int index=(i-min)/capacity;
            
            b[index].used=true;
            b[index].max_value=Math.max(b[index].max_value,i);
            b[index].min_value=Math.min(b[index].min_value,i);
            
        }
        int prev_bucket_max=min;
        int maxgap=0;
        for(Bucket g:b)
        {
            if(!g.used)
                continue;
            maxgap=Math.max(maxgap,g.min_value-prev_bucket_max);
            prev_bucket_max=g.max_value;
        }
        return maxgap;
    }
}