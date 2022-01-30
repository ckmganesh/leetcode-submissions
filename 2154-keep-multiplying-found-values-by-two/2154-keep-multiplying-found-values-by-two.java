class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet();
        for(int a:nums) set.add(a);
        while(true){
            if(set.contains(original))  original*=2;
            else break;
        }
        return original;
    }
}