class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(nums.length);
        HashSet<List<Integer>> result=new HashSet<>();
        for(int i=0;i<nums.length-2;i++)
        {
            int low=i+1;
            int high=nums.length-1;
            while(low<high)
            {
                int sum=nums[i]+nums[low]+nums[high];
                if(sum>0)
                    high--;
                else if(sum<0)
                    low++;
                else
                {
                   result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    low++;
                    high--;
                }
            }
        }
        System.out.println(result.size());
        return new ArrayList<>(result);
    }
}