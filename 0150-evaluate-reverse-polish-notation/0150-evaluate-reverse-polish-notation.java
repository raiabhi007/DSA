class Solution {
     public int evalRPN(String[] tokens) {
        int i = 0;
        int lastNum = -1;
        while (i < tokens.length) {
            if ("/*+-".contains(tokens[i])) {
                int val1 = Integer.valueOf(tokens[lastNum-1]);
                int val2 = Integer.valueOf(tokens[lastNum]);
                int ans = 0;
                if (tokens[i].equals("*"))
                    ans = val1*val2;
                else if (tokens[i].equals("/"))
                    ans = val1/val2;
                else if (tokens[i].equals("+"))
                    ans = val1+val2;
                else if (tokens[i].equals("-"))
                    ans = val1-val2;
                tokens[lastNum - 1] = Integer.toString(ans);
                lastNum--;
            } else {
                lastNum++;
                tokens[lastNum] = tokens[i];
            }
            i++;
        }
        return Integer.valueOf(tokens[lastNum]);
    }
}