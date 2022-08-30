class Solution {
    public int maxProfit(int[] arr, int fee) {
        int ossp = 0;
        int obsp = -arr[0];
        for(int i=1;i<arr.length;i++){
            int nssp = 0;
            int nbsp = 0;
            if(ossp-arr[i]>obsp){
                nbsp = ossp-arr[i];
            }else{
                nbsp = obsp;
            }
            if(arr[i]+obsp-fee>ossp){
                nssp = arr[i]+obsp-fee;
            }else{
                nssp = ossp;
            }
            ossp = nssp;
            obsp = nbsp;
        }
        return ossp;
    }
}