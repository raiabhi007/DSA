import java.math.BigInteger;  

class Solution {
    public String multiply(String num1, String num2) {
        BigInteger A = new BigInteger(num1);
        BigInteger B = new BigInteger(num2);
        String ans = ""+ A.multiply(B);
        return ans;
    }
}