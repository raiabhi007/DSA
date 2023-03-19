class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count[] = new int[nums.length+1];
        int totalCount = 0;
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&1)!=0)
                totalCount++;
            int temp = totalCount-k;
            if(temp>=0)
                ans+=count[temp];
            if(totalCount==k)
                ans++;
            count[totalCount]++;
        }
        return ans;
    }
}