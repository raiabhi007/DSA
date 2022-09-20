class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                int c = map.get(nums[i]);
                map.put(nums[i],++c);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>( (a, b)->a.getValue() - b.getValue());
        int ans[] = new int[k];
         for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            pq.add(it);
            if (pq.size() > k) pq.poll();
        }
        int i = k;
        while (!pq.isEmpty()) {
            ans[--i] = pq.poll().getKey();
        }
        return ans;
       
    }
}
