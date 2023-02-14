class Solution {
     public String addBinary(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        int n = Math.min(l1,l2);
        int i=0;
        Stack<String>store = new Stack<>();
        int carry =0;
        while(i<n){
            int add = (a.charAt(l1-i-1)-'0')+(b.charAt(l2-i-1)-'0')+carry;
            switch(add){
                case 0:
                    carry=0;
                    store.add("0");
                    break;
                case 1:
                    carry=0;
                    store.add("1");
                    break;
                case 2:
                    carry=1;
                    store.add("0");
                    break;
                case 3:
                    carry=1;
                    store.add("1");
                    break;
            }
            i++;
        }
        if(l1>l2){
            n=l1;
            while(i<n){
                int add = (a.charAt(l1-i-1)-'0')+carry;
            switch(add){
                case 0:
                    carry=0;
                    store.add("0");
                    break;
                case 1:
                    carry=0;
                    store.add("1");
                    break;
                case 2:
                    carry=1;
                    store.add("0");
                    break;
            }
            i++;
            }

        }
        else if(l2>l1){
            n=l2;
            while(i<n){
                int add = (b.charAt(l2-i-1)-'0')+carry;
            switch(add){
                case 0:
                    carry=0;
                    store.add("0");
                    break;
                case 1:
                    carry=0;
                    store.add("1");
                    break;
                case 2:
                    carry=1;
                    store.add("0");
                    break;
            }
            i++;
            }
        }
        if(carry==1)store.add("1");
        String ans = "";
        while(!store.isEmpty()){
            ans+=store.peek();
            store.pop();
        }
        return ans;
    }
}