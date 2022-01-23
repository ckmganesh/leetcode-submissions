class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> result = new ArrayList();
        int lower = pricing[0],upper=pricing[1];
PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] == b[1] ? a[2] == b[2] ? a[3] - b[3] : a[2] - b[2] : a[1] - b[1] : a[0] - b[0]);
        queue.add(new int[]{0,grid[start[0]][start[1]],start[0],start[1]});
        HashSet<String> visited = new HashSet();
        visited.add(start[0]+" "+start[1]);
        int directions[][]= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty() && result.size()<k){
            int current[] = queue.poll();
            if(current[1]>=lower && current[1]<=upper){
                result.add(Arrays.asList(current[2],current[3]));
            }
            for(int dir[]:directions){
                int nextX = current[2]+dir[0];
                int nextY = current[3]+dir[1];
                if(nextX>=0 && nextX<grid.length && nextY>=0 && nextY<grid[0].length && !visited.contains(nextX+" "+nextY) && grid[nextX][nextY]>0){
                    visited.add(nextX+" "+nextY);
                    queue.add(new int[]{current[0]+1,grid[nextX][nextY],nextX,nextY});
                }
            }
        }
        return result;
    }
}