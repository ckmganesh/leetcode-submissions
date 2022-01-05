class Solution {
    List<List<String>> result = new ArrayList();
    public List<List<String>> partition(String s) {
        List<String> current = new ArrayList();
        generate(0,current,s);
        return result;
    }
    void generate(int index,List<String> current,String s){
        if(index==s.length())
            result.add(current);
        else{
            for(int i=index;i<s.length();i++){
                if(isPalindrome(s,index,i)){
                    current.add(s.substring(index,i+1));
                    generate(i+1,new ArrayList(current),s);
                    current.remove(current.size()-1);
                }
            }
        }
    }
    boolean isPalindrome(String s,int left,int right){
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}