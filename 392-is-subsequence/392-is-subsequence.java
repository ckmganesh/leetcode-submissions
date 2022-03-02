class Solution {
    public boolean isSubsequence(String s, String t) {

        int indexS=0,indexT=0;
        while(indexT<t.length() && indexS<s.length()){
            if(t.charAt(indexT)==s.charAt(indexS))
                indexS++;
            indexT++;
        }
        return indexS==s.length();
    }
}