class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> evenMap = new HashMap();
        HashMap<Integer,Integer> oddMap = new HashMap();
        int even=0,odd=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                evenMap.put(nums[i],evenMap.getOrDefault(nums[i],0)+1);
                even++;
            }
            else{
                oddMap.put(nums[i],oddMap.getOrDefault(nums[i],0)+1);
                odd++;
            }
        }
        int max_freq_odd=0,max_odd=0,second_max_freq_odd=0,second_max_odd=0;
        for(int a:oddMap.keySet()){
            if(oddMap.get(a)>max_freq_odd){
                second_max_freq_odd=max_freq_odd;
                second_max_odd=max_odd;
                max_freq_odd=oddMap.get(a);
                max_odd=a;
            }
            else if(oddMap.get(a)>second_max_freq_odd){
               second_max_freq_odd=oddMap.get(a);
               second_max_odd=a;
            }
        }
        int max_freq_even=0,max_even=0,second_max_freq_even=0,second_max_even=0;
        for(int a:evenMap.keySet()){
            if(evenMap.get(a)>max_freq_even){
                second_max_freq_even=max_freq_even;
                second_max_even=max_even;
                max_freq_even=evenMap.get(a);
                max_even=a;
            }
            else if(evenMap.get(a)>second_max_freq_even){
               second_max_freq_even=evenMap.get(a);
               second_max_even=a;
            }
        }
        int operationsEven=0,operationsOdd=0;
        operationsEven = even-max_freq_even;
        if(max_even != max_odd) operationsEven+= odd-max_freq_odd;
        else operationsEven+=odd-second_max_freq_odd;
        
        operationsOdd = odd-max_freq_odd;
        if(max_odd!=max_even) operationsOdd+=even-max_freq_even;
        else operationsOdd+=even-second_max_freq_even;
        
        return Math.min(operationsOdd,operationsEven);
    }
}