class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCase=0;
        for(int i=0;i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i))){
                upperCase++;
            }
        }
        if(upperCase==0 || upperCase==word.length()) return true;
        else if (upperCase==1) return Character.isUpperCase(word.charAt(0));
        return false;
    }
}