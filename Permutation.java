class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList();
        List<Integer> list=new ArrayList<Integer>();
        for(int n:nums)
            list.add(n);
        int n=nums.length;
        backtrack(n,list,result,0);
        
        return result;
        }
    void backtrack(int n,List<Integer> nums,List<List<Integer>> result,int index){
        if(index>n)
            return;
        if(index==n)
            result.add(new ArrayList<Integer>(nums));
        for(int i=index;i<n;i++){
            
            Collections.swap(nums,index,i);
            backtrack(n,nums,result,index+1);
            Collections.swap(nums,index,i);
            
        }
    } 
}