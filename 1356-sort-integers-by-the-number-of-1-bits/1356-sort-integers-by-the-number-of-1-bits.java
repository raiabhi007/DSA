class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[][] temp = new int[n][2];
        for(int i=0;i<n;i++){
            temp[i][0] = arr[i];
            temp[i][1] = count(arr[i]);
        }
        Arrays.sort(temp,(a,b)->(a[1]-b[1]));
        for(int i=0;i<n;i++)
            arr[i] = temp[i][0];
        return arr;
        
    }
    private int count(int n){
        int cnt = 0;
        while(n>0){
            if((n&1)!=0) cnt++;
            n = n>>1;
        }
        return cnt;
    }
}