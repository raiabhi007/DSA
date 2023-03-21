class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long prev = 0;
        long count = 0;
        
        for (int num: nums) {
            if (num == 0) {
                ++ prev;
                count += prev;
            } else {
                prev = 0;
            }
        }
        
        return count;
    }
}