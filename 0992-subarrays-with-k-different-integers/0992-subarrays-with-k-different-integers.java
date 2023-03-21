class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,nums.length,k)-atMost(nums,nums.length,k-1);
    }
    	private int atMost(int[] arr, int n, int k) {
		int i = 0;
		int j = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (j < n) {
			map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
			
			while (map.size() > k) {
				map.put(arr[i], map.get(arr[i]) - 1);
				if (map.get(arr[i]) == 0) {
					map.remove(arr[i]);
				}
				i++;
			}
			if (map.size() <= k) {
				count = count + (j - i) + 1;
			}
			j++;
		}
		return count;
	}
}