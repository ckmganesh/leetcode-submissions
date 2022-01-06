class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int dist[] = new int[1001];
        for(int trip[]:trips){
            dist[trip[1]]+=trip[0];
            dist[trip[2]]-=trip[0];
        }
        int total=0;
        for(int a:dist){
            total+=a;
            if(total>capacity) return false;
        }
        return true;
    }
}