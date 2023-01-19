class Solution {
     public int subarraysDivByK(int[] nums, int K) {
        int[] count = new int[K];
        count[0] = 1;
        int prefix = 0, res = 0;
        for (int num : nums) {
            prefix = (prefix + num % K + K) % K;
            res += count[prefix]++;
        }
        return res;
    }
}