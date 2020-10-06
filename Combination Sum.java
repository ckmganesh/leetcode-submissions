class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
         HashSet<List<Integer>> result=new HashSet();
        List<Integer> current =new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,current,result);
        return new ArrayList<>(result);
        
    }
    
    void dfs(int[] candidates,int target,int index,List<Integer> current,HashSet<List<Integer>> result)
    {
        if(target==0)
        {
            Collections.sort(current);
            result.add(current);
        return;
        }
        for(int i=0;i<candidates.length;i++)
        {
            if(candidates[i]>target)
                return;
            
            current.add(candidates[i]);
            dfs(candidates,target-candidates[i],i,new ArrayList<>(current),result);
            current.remove(current.size()-1);
                        
        }
    }
}