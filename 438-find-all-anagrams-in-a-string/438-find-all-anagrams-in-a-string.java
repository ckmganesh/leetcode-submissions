class Solution {
    public List<Integer> findAnagrams(String s, String p) {
     List<Integer> result = new ArrayList();
        int start=0,end=0;
        int count[] = new int[26];        //"cbaebabacd"
                                          //"abc"
        for(int i=0;i<p.length();i++){
            count[p.charAt(i)-'a']++;
        }
        int length = p.length();
        for(end=0;end<s.length();end++){
            if(end-start==p.length() && count[s.charAt(start++)-'a']++>=0){
                length++;
            }
            if(--count[s.charAt(end)-'a']>=0){
                length--;
            }
            
            if(length==0){
                result.add(start);
            }
        }
        return result;
    }
}