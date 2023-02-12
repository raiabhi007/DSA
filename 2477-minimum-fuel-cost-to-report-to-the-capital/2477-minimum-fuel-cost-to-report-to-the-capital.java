class Solution {
    private long ans = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= roads.length; i++)
            tree.add(new ArrayList<>());
        for (int[] road : roads) {
            tree.get(road[0]).add(road[1]);
            tree.get(road[1]).add(road[0]);
        }

        dfs(0, 0, tree, seats);
        return ans;
    }

    private int dfs(int city, int prev, List<List<Integer>> tree, int seats) {
        int reps = 1; 
        for (int connectedCity : tree.get(city)) {
            if (connectedCity == prev) continue; 
            reps += dfs(connectedCity, city, tree, seats); 
        }
        if (city != 0) ans += (reps + seats - 1) / seats;
        return reps;
    }
}