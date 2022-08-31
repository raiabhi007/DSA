class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;
        for(int i=0;i<=rowIndex;i++){
            row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)
                    row.add(1);
                else
                    row.add(pre.get(j-1)+pre.get(j));
            }
            pre = row;
            res.add(row);
        }
        return res.get(rowIndex);
    }
}