class Solution {
    int total=0;
    
    int[][] direction={{0,1},{1,0},{-1,0},{0,-1}};
    public void walk(int[][] grid ,int x,int y,int possible_cells)
    { System.out.println(x +" " +y);
        if(possible_cells==1 && grid[x][y]==-8)
        {
            total++;
            return;
        }
        
        for(int i=0;i<4;i++)
        {
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];
           
            if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]>=0)
            {
            grid[nx][ny]-=10;
            walk(grid,nx,ny,possible_cells-1);
            grid[nx][ny]+=10;
            }
        }
        
    }
    public int uniquePathsIII(int[][] grid) {
        int possible_cells=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]>=0)
                possible_cells+=1;
            }
        }
        
        
    
    for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {grid[i][j]-=10;
                    walk(grid,i,j,possible_cells);}
            }
        }
        
     return total;   
    }
}