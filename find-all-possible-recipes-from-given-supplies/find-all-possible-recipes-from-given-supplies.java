class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int indegree[] = new int[ingredients.size()];
        for(int i=0;i<indegree.length;i++){
            indegree[i]=ingredients.get(i).size();
        }
        Stack<String> stack = new Stack();
        List<String> result = new ArrayList();
        for(String a:supplies) stack.push(a);
        while(!stack.isEmpty()){
            String top = stack.pop();
            
            for(int i=0;i<ingredients.size();i++){
                if(indegree[i]!=0){
                    HashSet<String> set = new HashSet(ingredients.get(i));
                    if(set.contains(top)) indegree[i]--;
                    if(indegree[i]==0){
                        stack.push(recipes[i]);
                        result.add(recipes[i]);
                    }
            }
        }
            
        }
        return result;
    }
}