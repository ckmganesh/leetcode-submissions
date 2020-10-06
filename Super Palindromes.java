class Solution {
    public int superpalindromesInRange(String L, String R) {
        
        long left=Long.valueOf(L);
        long right=Long.valueOf(R);
        int magic=100000;
        int count=0;
        for(int k=1;k<magic;k++)
        {
            StringBuilder sb=new StringBuilder(Integer.toString(k));
            for(int i= sb.length()-2;i>=0;i--)
                sb.append(sb.charAt(i));
            long v=Long.valueOf(sb.toString());
            v*=v;
            if(v>right)
            {
                break;
            }
            if(v>= left && isPalindrome(v))
            {
                count++;
            }
        }
        for(int k=1;k<magic;k++)
        {
            StringBuilder sb=new StringBuilder(Integer.toString(k));
            for(int i= sb.length()-1;i>=0;i--)
                sb.append(sb.charAt(i));
            long v=Long.valueOf(sb.toString());
            v*=v;
            if(v>right)
            {
                break;
            }
            if(v>= left && isPalindrome(v))
            {
                count++;
            }
        }
        
        return count;
        
    }
    
    public boolean isPalindrome(long x)
    {
        return x == reverse(x);
    }
    
    public long reverse(long x)
    {
        long ans=0;
        
        while(x>0)
        {
            ans=10*ans + x%10;
            x/=10;
        }
        return ans;
    }
}