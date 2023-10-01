class Solution {
    public int[] replaceElements(int[] arr) {
        int ele = -1;
        for(int i=arr.length-1;i>=0;i--){
            int temp = ele;
            ele = Math.max(ele,arr[i]);
            arr[i] = temp;
        }
        return arr;
    }
}