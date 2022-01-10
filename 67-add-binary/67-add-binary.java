class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry=0,i=a.length()-1,j=b.length()-1;
        while(i>=0 || j>=0 || carry>0){
            char first='0',second='0';
            if(i>=0){
                first = a.charAt(i);
                i--;
            }
            if(j>=0){
                second = b.charAt(j);
                j--;
            }
            char temp='0';
           if(first== '0' && second== '0' && carry==0){
               temp = '0';
               carry=0;
           }
            else if(first== '0' && second== '0' && carry==1){
                temp='1';
                carry=0;
            }
            else if(first== '0' && second== '1' && carry==0){
                temp='1';
                carry=0;
            }
            else if(first== '0' && second== '1' && carry==1){
                temp='0';
                carry = 1;
            }
            else if(first== '1' && second== '0' && carry==0){
                temp='1';
                carry=0;
            }
            else if(first== '1' && second== '0' && carry==1){
                temp='0';
                carry=1;
            }
            else if(first== '1' && second== '1' && carry==0){
                temp='0';
                carry=1;
            }
            else if(first== '1' && second== '1' && carry==1){
                temp='1';
                carry=1;
            }
            sb.append(temp);
        }
        return sb.reverse().toString();
    }
}