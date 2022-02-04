class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int gridId=2;
        
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area = helper(grid,i,j,gridId);
                    map.put(gridId,area);
                    gridId++;
                }
            }
        }
        int result=map.getOrDefault(2,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> set = new HashSet();
                     set.add(i<n-1 ? grid[i+1][j] :0);
                     set.add(j<n-1 ? grid[i][j+1] :0);
                     set.add(i>0 ? grid[i-1][j] :0);
                     set.add(j>0 ? grid[i][j-1] :0);
                    int totalArea=1;
                    for(int a:set) totalArea+=map.get(a);
                    result = Math.max(result,totalArea);   
                }
            }
        }
        return result;
        
    }
    int helper(int grid[][],int i,int j,int gridId){
        if(i>=grid.length || i<0 || j>=grid.length || j<0 || grid[i][j]!=1) return 0;
        grid[i][j]=gridId;
        return 1+helper(grid,i+1,j,gridId)+helper(grid,i,j+1,gridId)+helper(grid,i,j-1,gridId) + helper(grid,i-1,j,gridId);
    }
}