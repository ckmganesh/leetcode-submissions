class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return false;
        int m=matrix.length,n=matrix[0].length;
        int left = 0,right=m*n-1;
        while(left<=right){
            int mid = (left+right)/2;
            int mid_value = matrix[mid/n][mid%n];
            if(mid_value==target) return true;
            else if(mid_value>target) right=mid-1;
            else left=mid+1;
        }
        return false;
    }
}