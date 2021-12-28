class Solution {
    public int findKthLargest(int[] nums, int k) {
        k=nums.length-k;
        return helper(nums,k,0,nums.length-1);
    }
    int helper(int nums[],int k,int left,int right){
        int pivot = nums[right];
        int partition = left;
        for(int i=left;i<right;i++){
            if(nums[i]<=pivot){
                int temp = nums[i];
                nums[i]=nums[partition];
                nums[partition]=temp;
                partition++;
            }
        }
        int temp = nums[right];
        nums[right]=nums[partition];
        nums[partition]=temp;
        if(partition>k) return helper(nums,k,left,partition-1);
        else if(partition<k) return helper(nums,k,partition+1,right);
        else return nums[k];
                
    }
}