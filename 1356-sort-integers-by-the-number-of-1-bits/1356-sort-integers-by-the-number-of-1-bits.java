class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[][] temp = new int[n][2];
        for(int i=0;i<n;i++){
            temp[i][0] = arr[i];
            temp[i][1] = counter(arr[i]);
        }
        Arrays.sort(temp,(a,b)->(a[1]-b[1]));
        for(int i=0;i<n;i++)
            arr[i] = temp[i][0];
        return arr;
        
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