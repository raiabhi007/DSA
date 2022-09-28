class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        String[] roman = s.split("");
        int sum = 0;
        int size = roman.length;
        for(int i=0;i<size-1;i++){
            if(map.get(roman[i])<map.get(roman[i+1]))
                sum-=map.get(roman[i]);
            else
                sum+=map.get(roman[i]);
        }
        sum+=map.get(roman[size-1]);
        return sum;
    }
}