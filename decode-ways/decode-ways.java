class Solution {
    Integer dp[];
    public int numDecodings(String s) {
        dp=new Integer[s.length()];
        return helper(s,0);
    }
    int helper(String s,int index){
        if(index==s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        if(dp[index]!=null) return dp[index];
        int ways=0;
        ways+=helper(s,index+1);
        if(index+1<s.length() && Integer.valueOf(s.substring(index,index+2))<=26){
            ways+=helper(s,index+2);
        }
        return dp[index]=ways;
    }
}