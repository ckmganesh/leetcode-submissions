class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
       if(words.length!=pattern.length()) return false;
        HashMap<Character,String> map = new HashMap();
        HashMap<String,Character> smap = new HashMap();
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(words[i])) return false;
            }
            else if(smap.containsKey(words[i])){
                if(smap.get(words[i])!=pattern.charAt(i)) return false;
            }
            else{
                map.put(pattern.charAt(i),words[i]);
                smap.put(words[i],pattern.charAt(i));
            }
        }
        return true;
    }
}