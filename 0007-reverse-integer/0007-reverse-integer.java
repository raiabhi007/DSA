class Solution {
    public int reverse(int x) {
        long reverse = 0;
            
        //As long as x is not qual to zero   
        while (x != 0){
            int remainder = x % 10;
            reverse = reverse * 10 + remainder;
            x /= 10;
        }
          
        
        // Check the range of the signed 32 bit integer
        if (reverse >= Integer.MIN_VALUE && reverse <= Integer.MAX_VALUE){
            return (int)reverse;
        }else{
            return 0;
        }
        
    }
}