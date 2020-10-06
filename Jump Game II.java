class Solution {
    public int jump(int[] nums) {
        int position =nums[0];
        System.out.println(nums.length);
        int max_position=nums[0];
        if(nums.length ==1)
        {
            return 0;
        }
        int jumps=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>position)
            {
                jumps++;
                position=max_position;
            }
            max_position=Math.max(max_position,nums[i]+i);
        }
        
        return jumps+1;
        
    }
}