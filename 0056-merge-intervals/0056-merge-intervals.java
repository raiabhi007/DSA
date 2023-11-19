class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(res.get(res.size()-1)[1]>=intervals[i][0]){
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],intervals[i][1]);
            }else
                res.add(intervals[i]);
        }
        int ans[][] = new int[res.size()][2];
        res.toArray(ans);
        return ans;
    }
}