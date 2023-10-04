class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        boolean flag = true;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<wall.size();i++){
            int pos = 0;
            if(wall.get(i).size()>1) flag = false;
            for(int j=0;j<wall.get(i).size()-1;j++){
                pos+=wall.get(i).get(j);
                if(map.containsKey(pos)==false){
                    map.put(pos,1);
                }else
                    map.put(pos,map.get(pos)+1);
            }
        }
        int n = wall.size();
        if(flag) return n;
        
        int ans = Integer.MAX_VALUE;
        for(int pos : map.keySet()){
            ans = Math.min(ans,n-map.get(pos));
        }
        return ans;
    }
}