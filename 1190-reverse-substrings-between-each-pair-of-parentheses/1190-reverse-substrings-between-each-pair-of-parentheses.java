class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack();
        char arr[] = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='(') stack.push(i);
            else if(arr[i]==')'){
                reverseString(arr,stack.pop(),i-1);
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=')' && arr[i]!='(') result.append(arr[i]);
        }
        return result.toString();
    }
    void reverseString(char arr[],int left,int right){
        while(left<right){
            char temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    
}