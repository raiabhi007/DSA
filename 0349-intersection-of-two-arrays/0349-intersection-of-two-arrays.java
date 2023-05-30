class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet();
        List<Integer> arr = new ArrayList<>();

        for(int i:nums1){
            set.add(i);
        }

        for(int i:nums2){
            if(set.contains(i)){
                arr.add(i);
                set.remove(i);
            }
        }

        int[] resultArray = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            resultArray[i] = arr.get(i);
        }

        return resultArray;
    }
}