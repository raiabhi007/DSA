class Solution {
    String ans =  "";
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        helper(set,n,"");
        return ans;
    }
    public void helper(HashSet<String> set, int n,String asf){
        if(!ans.equals(""))
            return;
        if(n==0){
            if(!set.contains(asf))
                ans = new String(asf);
            return;
        }
        helper(set,n-1,asf+"0");
        helper(set,n-1,asf+"1");
    }
}