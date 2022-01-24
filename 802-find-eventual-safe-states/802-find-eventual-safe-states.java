class Solution {
    HashSet<Integer> visited = new HashSet();
    HashSet<Integer> visiting = new HashSet();
    List<Integer> list = new ArrayList();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        if(graph.length==0 || graph==null){
            return list;
        }
        for(int i=0;i<graph.length;i++){
            if(!isCycle(graph,i)){
                list.add(i);
            }
        }
        return list;
    }
    boolean isCycle(int graph[][],int index){
        if(visiting.contains(index)){
            return true;
        }
        if(visited.contains(index)){
            return false;
        }
        visiting.add(index);
        for(int a:graph[index]){
            if(isCycle(graph,a)){
                return true;
            }
        }
        visiting.remove(index);
        visited.add(index);
        return false;
    }
}