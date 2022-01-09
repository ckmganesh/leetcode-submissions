class Solution {
    public int minSwaps(int[] nums) {
        int ones=0;
        for(int a:nums) if(a==1) ones++;
        int end=0,count=0,result=nums.length;
        for(int start=0;start<nums.length;start++){
            while(end-start<ones){
                count+=nums[end++ %nums.length];
            }
            result=Math.min(result,ones-count);
            count-=nums[start];
        }
        return result;
    }
}