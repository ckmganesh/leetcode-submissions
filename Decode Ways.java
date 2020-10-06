class Solution {
    public int numDecodings(String s) {
        Integer[] dp=new Integer[s.length()+1];
        return decode(s,0,dp);
    }
    public int decode(String s,int index,Integer[] dp)
    {
        if(index==s.length())
        {
            return 1;
        }
        if(s.charAt(index)=='0')
        {
            return 0;
        }
        if(dp[index]!=null)
        {
            return dp[index];
        }
        int one=decode(s,index+1,dp);
        int two=0;
        if(index<s.length()-1 && Integer.valueOf(s.substring(index,index+2))<=26)
        {
         two=decode(s,index+2,dp); 
        }
        dp[index]=one+two;
        return dp[index];
            
    }
      
}