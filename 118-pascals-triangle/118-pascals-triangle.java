class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        for(int n=2;n<=numRows;n++){
            ans.add(new ArrayList<>());
            for(int i=0;i<n;i++){
                if(i==0||i==n-1)
                    ans.get(n-1).add(1);
                else{
                    int k = ans.get(n-2).get(i-1)+ans.get(n-2).get(i);
                    ans.get(n-1).add(k);
                } 
            }
        }
        return ans;
    }
}