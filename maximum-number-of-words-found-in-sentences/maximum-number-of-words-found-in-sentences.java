class Solution {
    public int mostWordsFound(String[] sentences) {
        int max=0;
        for(String str:sentences){
            int current = str.split(" ").length;
            max=Math.max(max,current);
        }
        return max;
    }
}