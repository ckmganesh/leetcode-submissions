class Solution {
    public boolean checkValid(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            int xor1=0,xor2=0;
            for(int j=0;j<matrix.length;j++){
                xor1^=(matrix[i][j])^(j+1);
                xor2^=(matrix[j][i])^(j+1);
            }
            if(xor1!=0 || xor2!=0) return false;
        }
        return true;
    }
}