class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=1000000000;
        int total=0,result=0;
        while(left<=right){
            int mid = (left+right)/2;
            total=0;
            if(helper(piles,mid,h)){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    boolean helper(int piles[],int mid,int h){
        int total=0;
        for(int p:piles){
            total+=(p/mid);
            if(p%mid!=0) total++;
        }
        return total<=h;
    }
}