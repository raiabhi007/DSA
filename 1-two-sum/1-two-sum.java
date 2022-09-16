class Solution {
    public int[] twoSum(int[] arr, int target) {
        int ans[] = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                ans[0] = map.get(target-arr[i]);
                ans[1] = i;
                break;
            }
            map.put(arr[i],i);
        }
        return ans;
    }
}