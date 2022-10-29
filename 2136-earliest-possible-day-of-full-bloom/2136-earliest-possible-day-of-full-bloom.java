class Solution {
    public class Pair implements Comparable<Pair>{
        int pt;   //plantTime
        int gt;   //growTime
        Pair(int pt, int gt){
            this.pt=pt;
            this.gt=gt;
        }
        public int compareTo(Pair o){
            if(this.gt==o.gt){
                //if the grow time is same, then reverse sort on the basis of plantTime
                return o.pt-this.pt;
            }
            //reverse sort the array on the basis of grow time
            return o.gt-this.gt;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int pt=0;      //pt=plantTime;
        Pair[] arr=new Pair[plantTime.length];
        for(int i=0;i<arr.length;i++){
            //make the pair for each index of PlantTime and growTime
            arr[i]=new Pair(plantTime[i],growTime[i]);
        }
        //Reverse sort the array, first on the basis of growTime and if growTime of two plants are same, then reverse sort on the basis of plantTime
        Arrays.sort(arr);
        int maximumTime=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            pt+=arr[i].pt;
            maximumTime=Math.max(maximumTime,pt+arr[i].gt);
        }
        return maximumTime;   
    }
}