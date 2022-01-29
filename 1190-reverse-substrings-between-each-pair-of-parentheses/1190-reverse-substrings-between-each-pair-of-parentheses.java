class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack();
        int pair[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push(i);
            else if(s.charAt(i)==')'){
                pair[i]=stack.peek();
                pair[stack.pop()]=i;
            }
        }
        StringBuilder result = new StringBuilder();
        int direction=1;
        for(int i=0;i<s.length();i+=direction){
           if(s.charAt(i)=='(' || s.charAt(i)==')'){
               i=pair[i];
               direction=-direction;
           }
            else{
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
    
}
    
