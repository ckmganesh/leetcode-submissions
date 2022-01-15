// class Solution {
//     HashMap<Integer,List<Integer>> map = new HashMap();
//     public int minJumps(int[] arr) {
//         for(int i=0;i<arr.length;i++){
//             List<Integer> list = map.getOrDefault(arr[i],new ArrayList());
//             list.add(i);
//             map.put(arr[i],list);
//         }
//         return helper(0,arr);
//     }
//     int helper(int index,int arr[]){
//         if(index==arr.length-1) return 0;
//         int way1=Integer.MAX_VALUE,way2=Integer.MAX_VALUE,way3=Integer.MAX_VALUE;
//         if(index+1<arr.length)
//         way1 = 1+helper(index+1,arr);
        
//         if(index-1>=0) way2=1+helper(index-1,arr);
        
//         if(map.get(arr[index]).size()>1){
//             for(int a:map.get(arr[index])){
//                 if(a!=index) way3=1+helper(a,arr);
//             }
//         }
        
//         return Math.min(way1,Math.min(way2,way3));
        
//     }
// }

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> indicesOfValue = new HashMap<>();
        for (int i = 0; i < n; i++)
            indicesOfValue.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        boolean[] visited = new boolean[n]; visited[0] = true;
        Queue<Integer> q = new LinkedList<>(); q.offer(0);
        int step = 0;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                int i = q.poll();
                if (i == n - 1) return step; 
                List<Integer> next = indicesOfValue.get(arr[i]);
                next.add(i - 1); next.add(i + 1);
                for (int j : next) {
                    if (j >= 0 && j < n && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
                next.clear(); // avoid later lookup indicesOfValue arr[i]
            }
            step++;
        }
        return 0;
    }
}