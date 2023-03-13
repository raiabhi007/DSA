class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean board[][] = new boolean[n][n];
        boolean col[] = new boolean[n];
        boolean d1[] = new boolean[2*n-1];
        boolean d2[] = new boolean[2*n-1];
        List<String> list = new ArrayList<>();
        nQueen(col,d1,d2,0,list);
        return ans;
    }
    public void nQueen(boolean[] col,boolean[] d1,boolean[] d2,int i,List<String> list){
        int n = col.length;
        if(i==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j=0;j<n;j++){
            if(col[j]==false&&d1[i+j]==false&&d2[i-j+n-1]==false){
                col[j] = true;
                d1[i+j] =true;
                d2[i-j+n-1] = true;
                String s = "";
                for(int k=0;k<n;k++){
                    if(k==j)
                        s = s+"Q";
                    else
                        s = s+".";
                }
                list.add(s);
                nQueen(col,d1,d2,i+1,list);
                    list.remove(list.size()-1);
                col[j] = false;
                d1[i+j] = false;
                d2[i-j+n-1] = false;
            }
        }
    }
}