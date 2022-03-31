class Solution {
    public int maxProduct(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int curProduct = 1;
        
        for(int i=0;i<arr.length;i++){
            curProduct*=arr[i];
            ans = Math.max(ans,curProduct);
            if(curProduct==0)
                curProduct = 1;
        }
        curProduct = 1;
        for(int i=arr.length-1;i>=0;i--){
            curProduct*=arr[i];
            ans = Math.max(ans,curProduct);
            if(curProduct==0)
                curProduct = 1;
        }
        return ans;
    }
}