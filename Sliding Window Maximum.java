class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || nums==null || nums.length<k)
        {
            return new int[0];
        }
       int left[]=new int[nums.length];
        int right[] =new int[nums.length];
        int result[] =new int[nums.length-k+1];
        left[0]=nums[0];
         right[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++)
        {
            if(i%k==0)
            {left[i]=nums[i];}
            
            else {
                left[i]=Math.max(left[i-1],nums[i]);
            }
            int j=nums.length-i-1;
            if(j%k==(k-1))
            {
                right[j]=nums[j];
            }
            else
            {
                right[j]=Math.max(right[j+1],nums[j]);
            }
        }
        for(int i=0,j=i+k-1;j<nums.length;i++,j++)
        {
            result[i]=Math.max(right[i],left[j]);
        }
        return result;
}
}