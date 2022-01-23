class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        List<Integer> result = new ArrayList();
        for(int a:map.keySet()){
            if(map.get(a)==1 && !map.containsKey(a+1) && !map.containsKey(a-1)) result.add(a);
        }
        return result;
    }
}