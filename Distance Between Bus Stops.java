class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int cd=0,total=0;
        for(int i=0;i<distance.length;i++)
        {
            if(start<destination && ( i>=start &&i<destination))
            {
                cd+=distance[i];
            }
            if(start>destination&& (i>=start || i<destination))
            {
                cd+=distance[i];
            }
            total+=distance[i];
        }
        return Math.min(cd,total-cd);
        
    }
}