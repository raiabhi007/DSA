class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int sum=0;
        int result = Integer.MAX_VALUE;
        int lsize = Integer.MAX_VALUE;
        hmap.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            hmap.put(sum,i);
        } 
        sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hmap.get(sum-target)!=null){
                lsize = Math.min(lsize,i-hmap.get(sum-target));
            }
            if(hmap.get(sum+target)!=null&&lsize<Integer.MAX_VALUE){
                result = Math.min(result,hmap.get(sum+target)-i+lsize);
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}