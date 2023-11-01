class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int mod = k==0?sum:sum%k;
            if(map.containsKey(mod)&& i-map.get(mod)>1) return true;
            map.putIfAbsent(mod,i);
        }
        return false;
    }
}