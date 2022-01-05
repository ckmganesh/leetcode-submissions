class Solution {
    public int minimumBuckets(String street) {
        StringBuilder str = new StringBuilder(street);
        int result=0;
        for(int i=0;i<street.length();i++){
            if(str.charAt(i)=='H'){
                if(i>0 && str.charAt(i-1)=='B') continue;
                else if(i+1<str.length() && str.charAt(i+1)=='.'){
                    result++;
                    str.setCharAt(i+1,'B');
                }
                else if(i-1>=0 && str.charAt(i-1)=='.'){
                    result++;
                    str.setCharAt(i-1,'B');
                }
                else return -1;
            }
        }
        return result;
    }
}