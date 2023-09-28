class Solution {
     public int[] sortArrayByParity(int[] A) {
        int[] arr = new int[A.length];
        int begin = 0;
        int end = A.length - 1;
        for(int i = 0;i < A.length;i++){
            //[3,1,2,4]
            if(A[i] % 2 == 0){
                arr[begin++] = A[i];
            }else{
                arr[end--] = A[i];
            }
        }
        return arr;
    }
}