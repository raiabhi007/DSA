class Solution {
    public int deleteAndEarn(int[] nums) {
        int a = 0;
        int b = 0;
        int[] count = new int[10001];
        for(int val:nums)
            count[val]++;
        for(int i=0;i<=10000;i++){
            int c = a + count[i]*i;
            a = b;
            b = Math.max(c,b);
        }
        return b;
    }
}