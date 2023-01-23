class Solution {
    public int findJudge(int n, int[][] t) {
    if(n==1)
        return 1;
    HashMap<Integer,Integer> nm=new HashMap<>();
    int k=t.length;
    for(int i[]: t)
    {
        nm.put(i[0] , nm.getOrDefault(i[0],0)+(-1));
        nm.put(i[1] , nm.getOrDefault(i[1],0)+1);
    }
    for(int i:nm.keySet())
    {
        if(nm.get(i)==n-1)
            return i;
    }
    return -1;
}
}