class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
        {
            return image;
        }
        fillcolor( image,  sr,  sc, image[sr][sc],  newColor);
        return image;
    }
    public void fillcolor(int[][] image, int sr, int sc,int color, int newColor)
    {
        if(sr>=image.length || sc>=image[0].length || sr<0 || sc<0 || image[sr][sc]!=color)
        {return;}
        image[sr][sc]=newColor;
        fillcolor(image,sr-1,sc,color,newColor);
        fillcolor(image,sr+1,sc,color,newColor);
        fillcolor(image,sr,sc+1,color,newColor);
        fillcolor(image,sr,sc-1,color,newColor);



    }
}