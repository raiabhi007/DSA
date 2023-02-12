import java.math.BigInteger;
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        String s = "";
        for(int i=0;i<num.length;i++){
            s+=num[i];
        }
        BigInteger A = new BigInteger(s);
        BigInteger C = A.add(BigInteger.valueOf(k));
        s = ""+C;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            ans.add(s.charAt(i)-'0');
        }
        return ans;
    }
}