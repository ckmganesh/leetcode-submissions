class Solution {
    public int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    class Cell implements Comparable<Cell>{
        int row,col,height;
         Cell(int r,int c,int h)
        {
            this.row=r;
            this.col=c;
            this.height=h;
        }
          public int compareTo(Cell otherCell) {
            if (this.height == otherCell.height) return 0;
            if (this.height < otherCell.height) return -1;
            return 1;
        } 
    }
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Cell> heap=new PriorityQueue<>();
        boolean[][] visited=new boolean[heightMap.length][heightMap[0].length];
        for(int i=0;i<heightMap.length;i++)
        {
             visited[i][0]=true;
            visited[i][heightMap[0].length-1]=true;
            heap.add(new Cell(i,0,heightMap[i][0]));
            heap.add(new Cell(i,heightMap[0].length-1,heightMap[i][heightMap[0].length-1]));

        }
        for(int i=0;i<heightMap[0].length;i++)
        {
            visited[0][i]=true;
            visited[heightMap.length-1][i]=true;
            heap.add(new Cell(0,i,heightMap[0][i]));
            heap.add(new Cell(heightMap.length-1,i,heightMap[heightMap.length-1][i]));

        }
        int total=0;
        while(!heap.isEmpty())
        {
            Cell cl=heap.poll();
            int row=cl.row,col=cl.col,height=cl.height;
            for(int[] dr :dir)
            {
                int nextrow=dr[0]+row;
                int nextcol=dr[1]+col;
                if (nextrow > 0 && nextrow < heightMap.length - 1 && nextcol > 0 && nextcol < heightMap[0].length- 1 && !visited[nextrow][nextcol]) {
                    visited[nextrow][nextcol] = true;
                    
                    total += Math.max(0, height - heightMap[nextrow][nextcol]);
                    heap.offer(new Cell(nextrow, nextcol, Math.max(height, heightMap[nextrow][nextcol])));
            }
            
        }
        
    }
        return total;
}
}