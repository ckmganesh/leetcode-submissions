class Solution {
    int pair[];
    public int scoreOfParentheses(String s) {
        pair = new int[s.length()];
        Stack<Integer> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') stack.push(i);
            else{
                int top = stack.pop();
                pair[top]=i;
            }
        }
        return helper(0,s.length()-1);
    }
    int helper(int low,int high){
        if(low+1==high) return 1;
        int close = pair[low];
        if(close==high) return 2*helper(low+1,high-1);
        return helper(low,close) + helper(close+1,high);
    }
}