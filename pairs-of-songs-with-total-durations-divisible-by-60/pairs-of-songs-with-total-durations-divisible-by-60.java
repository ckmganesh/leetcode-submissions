class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map = new HashMap();
        int result=0;
        for(int t:time){
            result+=map.getOrDefault((60-(t%60))%60,0);
            map.put(t%60,map.getOrDefault(t%60,0)+1);
        }
        return result;
    }
}