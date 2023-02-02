class Solution {
    public int[] sortByBits(int[] arr) {
         int[] bits = new int[arr.length];
        int[] ans = new int[arr.length];
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int count = 0;
            int n = arr[i];
            bits[i] = counter(n);
        }
        int l = 0;
        for(int j = 0; j <= 14; j++){
            int length = 0;
            for(int k = 0; k < bits.length; k++){
                if(j == bits[k]){
                    length++;
                    ans[l] = arr[k];
                    l++;
                }
            }
        }
        return ans;
    }
    int counter(int k){
        int count = 0;
        while(k>0){
            int rsb = k& -k;
            k-=rsb;
            count++;
        }
        return count;
    }
}