class Solution {
    public int maxDistToClosest(int[] seats) {
        int max=0,left=-1;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                if(left==-1){
                    max=i;
                }
                else{
                    max=Math.max(max,(i-left)/2);
                    
                }
                  left=i;
            }
        }
        if(seats[seats.length-1]==0) max=Math.max(max,seats.length-1-left);
        return max;
    }
}