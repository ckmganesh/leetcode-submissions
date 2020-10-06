class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int[] bits = new int[32];
        int result=0;
        for(int i=0;i<32;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                bits[i]+= nums[j]>>i & 1;
                bits[i]%=3;
                
            }
        }
        
        for(int i=0;i<32;i++)
        {System.out.println(bits[i]);
            result|=(bits[i] << i);
        }
        return result;
        
    }
}