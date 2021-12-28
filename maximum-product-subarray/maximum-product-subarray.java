class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0],current_max=nums[0],current_min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp = current_min;
                current_min=current_max;
                current_max=temp;
            }
            current_max=Math.max(nums[i],current_max*nums[i]);
            current_min=Math.min(nums[i],current_min*nums[i]);
            max=Math.max(max,current_max);
        }
        return max;
    }
}