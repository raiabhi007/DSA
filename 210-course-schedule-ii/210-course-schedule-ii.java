class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        } 
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        int topo[] = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(indegree[i]==0)
                q.add(i);
        int count = 0;
        int ind = numCourses-1;
        int ans[] = new int[numCourses];
        while(!q.isEmpty()){
            Integer node = q.poll();
            ans[ind--] = node;
            count++;
            for(Integer it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }
        }
        if(count==numCourses)
            return ans;
        int[] ans1 = {};
        return ans1;
    }
}