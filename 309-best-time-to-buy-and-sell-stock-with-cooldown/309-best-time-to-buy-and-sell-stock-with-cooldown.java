class Solution {
    public int maxProfit(int[] arr) {
        int obsp = -arr[0];
        int ossp = 0;
        int ocsp = 0;
        for(int i=1;i<arr.length;i++){
            int nssp = 0;
            int nbsp = 0;
            int ncsp = 0;
            if(ocsp-arr[i]>obsp){
                nbsp = ocsp-arr[i];
            }else
                nbsp = obsp;
            if(arr[i]+obsp>ossp)
                nssp = arr[i]+obsp;
            else
                nssp = ossp;
            if(ossp>ocsp){
                ncsp = ossp;
            }
            else
                ncsp = ocsp;
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        return ossp;
    }
}