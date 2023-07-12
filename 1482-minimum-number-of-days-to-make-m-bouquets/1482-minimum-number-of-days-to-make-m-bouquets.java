class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k>n)
            return -1;
        int low = 1;
        int high = 0;
        int ans = -1;
        for(int i=0;i<n;i++)
            high = Math.max(high,bloomDay[i]);
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(mid,bloomDay,m,k)){
                high = mid-1;
                ans = mid;
            }else
                low = mid+1;
        }
        return ans;
    }
    boolean isPossible(int mid,int[] bloomDay,int m,int k){
        int bouq = 0;
        int flower = 0;
        
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]>mid)
                flower = 0;
            else{
                flower++;
                if(flower==k){
                    bouq++;
                    flower = 0;
                }
            }
        }
        return bouq>=m;
    }
}