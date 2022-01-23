class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList();
        List<Integer> negative = new ArrayList();
        for(int a:nums){
            if(a>0) positive.add(a);
            else negative.add(a);
        }
        int k=0;
        for(int i=0;i<nums.length;i+=2){
            nums[i]=positive.get(k);
            nums[i+1]=negative.get(k++);
        }
        return nums;
        
    }
}
