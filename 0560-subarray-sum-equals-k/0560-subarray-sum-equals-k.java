class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int diff = sum-k;
            if(map.containsKey(diff)){
                ans+=map.get(diff);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}