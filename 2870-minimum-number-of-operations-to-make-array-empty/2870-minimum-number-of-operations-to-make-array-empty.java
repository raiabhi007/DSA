class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])==false){
                map.put(nums[i],1);
            }else
                map.put(nums[i],map.get(nums[i])+1);
        }
        int ans = 0;
        for(int it:map.keySet()){
            if(map.get(it)<2) return -1;
            if(map.get(it)%3==0){
                ans = ans+map.get(it)/3;
            }else if(map.get(it)%3==1||map.get(it)%3==2){
                ans = ans+map.get(it)/3+1;
            }else if(map.get(it)==2)
                ans+=1;
        }
        return ans;
    }
}