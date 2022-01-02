class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum=mass;
        for(int a:asteroids){
            if((long) a>sum) return false;
            sum+=a;
        }
        return true;
    }
}