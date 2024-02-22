class Solution {
    int count = 0;
    String ans = "";
    public String getPermutation(int n, int k) {
        boolean[] map = new boolean[n+1];
        helper(n,k,0,map,"");
        return ans;
        
    }
    public void helper(int n,int k,int idx,boolean[] map,String temp){
        if(idx==n){
            count++;
            if(count==k){
                ans = temp;
            }
            return;
        }
            for(int i=1;i<=n;i++){
                if(map[i]==false){
                    map[i]=true;
                    helper(n,k,idx+1,map,temp+i);
                    map[i] = false;
                }
            }
        
    }
}