class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int ans = 0;
        for(int i=0;i<nums.length;i++)
            count[nums[i]]++;
        for(int i=1;i<=100;i++){
            if(count[i]==0||count[i]==1) continue;
            ans+=((count[i]*(count[i]-1))/2);
        }
        return ans;
    }
}