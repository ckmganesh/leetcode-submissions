class Solution {
    public int myAtoi(String s) {
        if(s.length()==0) return 0;
        int sign=1,current=0,i=0;
        while(i<s.length() && s.charAt(i)==' ')  i++;
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign=s.charAt(i++)=='+'?1:-1;
        }
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
            if(current>Integer.MAX_VALUE/10 || (current==Integer.MAX_VALUE/10 && s.charAt(i)-'0'>Integer.MAX_VALUE%10)){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            current=current*10+(s.charAt(i++)-'0');
        }
        return current*sign;
    }
}