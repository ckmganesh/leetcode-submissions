class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0 || nums == null)
        {
            return 1;
        }
        int one=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                one=1;
            }
            else if (nums[i]>nums.length ||nums[i]<=0)
            {
                nums[i]=1;
            }
        }
        if(one == 0)
        {return 1;}
        for(int i=0;i<nums.length;i++)
        {
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0)
            {
            nums[index]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
           if(nums[i]>0)
           {
               return i+1;
           }
        }
        return nums.length+1;
    }
}