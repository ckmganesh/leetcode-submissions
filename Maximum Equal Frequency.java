class Solution {
    public int maxEqualFreq(int[] nums) {
        int[] count = new int[100001];
        int[] freq = new int[100001];

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
            freq[count[nums[i]]]++;
        }

        for (int i = n - 1; i > 0; i--) {
            if (count[nums[i]] * freq[count[nums[i]]] == i) {
                System.out.println(i);
                return i + 1;
            }

            freq[count[nums[i]]]--;
            count[nums[i]]--;

            if (count[nums[i - 1]] * freq[count[nums[i - 1]]] == i) {
                  System.out.println(i-1);
              return i + 1;
            }
        }

        return 1;
    }
}
         


        
