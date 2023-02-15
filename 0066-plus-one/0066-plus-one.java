class Solution {
    public int[] plusOne(int[] digits) {
         ArrayList<Integer> arr = new ArrayList<>();
        int n = 1;
        for(int i = digits.length-1;i>=0||n>0;i--){
            int cur = i>=0?digits[i]+n:n;
            arr.add(cur%10);
            n = cur/10;
        }
        int res[] = new int[arr.size()];
        int index = 0;
        for(int i = arr.size()-1;i>=0;i--)  res[index++] = arr.get(i);
        return res;
    }
}