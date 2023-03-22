class Solution {
    public boolean isPossibleDivide(int[] arr, int k) {
        int n = arr.length;
        if(n%k!=0)
            return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        while(map.size()>0){
            int val = map.firstKey();
            for(int i=val;i<val+k;i++){
                if(!map.containsKey(i))
                    return false;
                map.put(i,map.get(i)-1);
                if(map.get(i)==0)
                    map.remove(i);
            }
        }
        return true;
    }
}