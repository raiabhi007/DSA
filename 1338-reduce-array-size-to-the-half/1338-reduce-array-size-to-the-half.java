class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hmap.get(arr[i])==null)
                hmap.put(arr[i],1);
            else{
                Integer c = hmap.get(arr[i]);
                hmap.put(arr[i],++c);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int key : hmap.keySet()){
            pq.add(hmap.get(key));
        }
        int ans = 0;
        int total = arr.length;
        while(total>arr.length/2){
            total = total - pq.remove();
            ans++;
        }
        return ans;
    }
}