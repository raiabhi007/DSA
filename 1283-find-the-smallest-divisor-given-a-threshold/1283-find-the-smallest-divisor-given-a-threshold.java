class Solution {
    public int smallestDivisor(int[] arr, int threshold) {
        int low = 1;
        int high = (int)Math.pow(10,9);
        int ans = -1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            int sum = 0;
            for(int i=0;i<arr.length;i++){
                int temp = arr[i]/mid;
                if(arr[i]%mid!=0)
                    temp+=1;
                sum+=temp;
            }
            if(sum<=threshold){
                ans = mid;
                high = mid-1;
            }else
                low = mid+1;
        }
        return ans;
    }
}