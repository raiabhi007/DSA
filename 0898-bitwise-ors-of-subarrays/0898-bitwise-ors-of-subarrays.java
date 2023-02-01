class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        ArrayList<Integer> res=new ArrayList<>();
		HashSet<Integer> ans = new HashSet<>();
		int left = 0, right;
		for (int i = 0; i < arr.length; i++) {
			right = res.size();
			res.add(arr[i]);
			for (int j = left; j < right; ++j) {
				if (res.get(res.size() -1) != (res.get(j) | arr[i])) {
					res.add(res.get(j) | arr[i]);
				}
			}
			left = right;
		}

		for (int i = 0; i < res.size(); i++) {
			ans.add(res.get(i));
		}
		return ans.size();
    }
}