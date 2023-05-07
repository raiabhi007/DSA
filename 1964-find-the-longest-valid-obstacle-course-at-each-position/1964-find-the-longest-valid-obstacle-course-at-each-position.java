class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] lis = new int[obstacles.length];
        int[] dp = new int[obstacles.length+1];
        int len=0,index=0;
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        lis[0]=1;
        for(int i=0;i<obstacles.length;i++){
            index=binarySearch(dp,obstacles[i],0,dp.length-1);
            index=index<0?-1-index:index;
            dp[index]=obstacles[i];
            lis[i]=index;
        }
        
        return lis;
    }
    int binarySearch(int[] arr,int num,int low,int high){
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(num >= arr[mid])
                low = mid + 1;
            else
                high = mid;
        }
        if(low>high){
            return -1;
        }
        return low;
    }
}