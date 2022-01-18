class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int placed=0;
        for(int i=0;i<flowerbed.length;i++){
            int next = i==flowerbed.length-1? 0:flowerbed[i+1];
            int prev = i==0? 0 : flowerbed[i-1];
            if(flowerbed[i]==0 && prev==0 && next==0){
                placed++;
                flowerbed[i]=1;
            }
        }
        return placed>=n;
    }
}