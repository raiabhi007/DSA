class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int count=0;
        for(int i=0;i<capacity.length;i++)
            capacity[i]=capacity[i]-rocks[i];
        Arrays.sort(capacity);
        for(int j=0;j<capacity.length;j++){
            if(capacity[j]==0)
                count++;
            else if(additionalRocks!=0 && additionalRocks>=capacity[j]){
                additionalRocks=additionalRocks-capacity[j];
                count++;
            }
        }
        return count;
    }

}