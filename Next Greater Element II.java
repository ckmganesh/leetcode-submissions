class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int dup[]=new int[2*nums.length];
        for(int i=0;i<dup.length;i++)
        {
            dup[i]=nums[i%nums.length];
        }
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[dup.length];
        for(int i=dup.length-1;i>=0;i--)
        {
            while(!stack.isEmpty()&&stack.peek()<=dup[i])
                stack.pop();
            if(stack.isEmpty())
                res[i]=-1;
            else
                res[i]=stack.peek();
            stack.push(dup[i]);
        }
        int result[]=Arrays.copyOfRange(res,0,nums.length);
        return result;
    }
}