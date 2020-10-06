class Solution {
    public int findDuplicate(int[] nums) {
        int f=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[Math.abs(nums[i])-1]>0)
            {
                nums[Math.abs(nums[i])-1]*=-1;
            }
            else
            {
                f= Math.abs(nums[i]);
                break;
            }
        }
        return f;
        
    }
}