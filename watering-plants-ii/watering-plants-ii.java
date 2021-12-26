class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count=0,a=0,b=plants.length-1,capA=capacityA,capB=capacityB;
        while(a<b){
            if(capA>=plants[a]){
                capA-=plants[a];
                a++;
            }
            else{
                count++;
                capA=capacityA-plants[a];
                a++;
            }
            if(capB>=plants[b]){
                capB-=plants[b];
                b--;
            }
            else{
                count++;
                capB=capacityB-plants[b];
                b--;
            }
        }
        if(plants.length%2==1){
            if(capA<plants[plants.length/2] && capB<plants[plants.length/2]) count++;
        }
        return count;
    }
}