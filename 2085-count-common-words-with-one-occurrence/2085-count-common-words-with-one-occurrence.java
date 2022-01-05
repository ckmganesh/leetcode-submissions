class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer> map = new HashMap();
        int result=0;
        for(String s:words1){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(String s:words2){
            if(map.containsKey(s)){
                if(map.get(s)>1) continue;
                else map.put(s,map.get(s)-1);
            }
        }
        for(String a:map.keySet()) if(map.get(a)==0) result++;
        return result;
    }
}