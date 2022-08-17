class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int[] children = new int[k];
        
        return distributeCookies(cookies,0,children,k);
    }
    
    public int distributeCookies(int[] cookies,int idx,int[] children,int k){
        if(idx == cookies.length){
            int max = -1;
            for(int val:children){
                max = Math.max(max,val);
            }
            return  max;
        }        
        
        
        int min = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            children[i] += cookies[idx];
            min = Math.min(min,distributeCookies(cookies,idx+1,children,k));
            children[i] -= cookies[idx];
        }
        return min;
    }
    
}