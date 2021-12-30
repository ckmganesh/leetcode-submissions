class Solution {
//     HashMap<Integer,Stack<Integer>> graph = new HashMap();
//     public int[][] validArrangement(int[][] pairs) {
//         HashMap<Integer,Integer> count = new HashMap();
//         for(int edge[]:pairs){
//             count.put(edge[0],count.getOrDefault(edge[0],0)+1);
//             count.put(edge[1],count.getOrDefault(edge[1],0)-1);
//             Stack<Integer> list = graph.getOrDefault(edge[0],new Stack());
//             list.push(edge[1]);
//             graph.put(edge[0],list);
//         }
//         int start = pairs[0][0];
//         for(int a:count.keySet()){
//             if(count.get(a)==1) {
//                 start=a;
//                 break;
//             }
//         }
//         HashSet<List<Integer>> euler = new HashSet();
//         dfs(start,euler);
//         List<List<Integer>> path = new ArrayList(euler);
//         int result[][] =  new int[euler.size()][2];
//         for(int i=path.size()-1;i>=0;i--){
//             result[path.size()-i-1][0]=path.get(i).get(0);
//             result[path.size()-i-1][1]=path.get(i).get(1);
//         }
//         return  result;
//     }
//     void dfs(int node,HashSet<List<Integer>> path){
        
//         if(graph.containsKey(node)){
//         for(int a:graph.get(node)){
//             if(!path.contains(Arrays.asList(node,a))){
//                 path.add(Arrays.asList(node,a));
//                  dfs(a,path);    
//         }    
//         }
//     }
//     }
    
    public int[][] validArrangement(int[][] pairs){
        Map<Integer, Stack<Integer>> g = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        for(int[] p : pairs){
            g.putIfAbsent(p[0], new Stack<>());
            g.get(p[0]).add(p[1]);
            out.put(p[0], out.getOrDefault(p[0], 0) + 1);
            out.put(p[1], out.getOrDefault(p[1], 0) - 1);
        }
        int start = out.keySet().stream().filter(k -> out.get(k) == 1).findFirst().orElse(pairs[0][0]);
        LinkedList<int[]> r = new LinkedList<>();
        arrange(start, g, r);
        return r.toArray(new int[0][]);
    }

    void arrange(int u, Map<Integer, Stack<Integer>> g, LinkedList<int[]> r){
        for(Stack<Integer> s = g.getOrDefault(u, null); s != null && !s.isEmpty(); ){
            Integer v = s.pop();
            arrange(v, g, r);
            r.addFirst(new int[]{u, v});
        }
    }
    
}