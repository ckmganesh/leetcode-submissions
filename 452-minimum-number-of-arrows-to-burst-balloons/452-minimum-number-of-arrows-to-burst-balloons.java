class Solution {
    public int findMinArrowShots(int[][] points) {
        int arrows=1;
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int end=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>end){
                arrows++;
                end=points[i][1];
            }
        }
        return arrows;
    }
}
// [[10,16],[2,8],[1,6],[7,12]]
// [1,6],[2,8],[7,12],[10,16]
//    |
//    |
// 1------6
//   2-------8
//        7-----12
//            10------16