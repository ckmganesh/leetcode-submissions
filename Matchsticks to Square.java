class Solution {
    public boolean makesquare(int[] nums) {

        if(nums.length==0 || nums==null)
            return false;
        int sums[]=new int[4];
        Integer num[]=new Integer[nums.length];
        
        int perimeter=0,ps=0;
        for(int i=0;i<nums.length;i++)
        {
            perimeter+=nums[i];
            num[i]=new Integer(nums[i]);
        }
        ps=perimeter/4;
        if(ps*4!=perimeter)
            return false;
        Arrays.sort(num,Collections.reverseOrder());
        return dfs(num,sums,ps,0);
        
    }
    public boolean dfs(Integer[] nums,int[] sums,int ps,int index)
    {
        if(index==nums.length)
        {
            return sums[0]==sums[1] && sums[1]==sums[2] && sums[2]==sums[3]; 
        }
        int e=nums[index];
        for(int i=0;i<4;i++)
        {
            if(e+sums[i]<=ps)
            {
                sums[i]+=e;
                if(dfs(nums,sums,ps,index+1))
                {return true;}
                sums[i]-=e;
            }
        }
        return false;
    }
}