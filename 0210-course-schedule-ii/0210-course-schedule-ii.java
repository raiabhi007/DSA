class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++)
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i))
                indegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(indegree[i]==0)
                q.add(i);
        int ans[] = new int[numCourses];
        int i = numCourses-1;
        while(!q.isEmpty()){
            int node = q.remove();
            ans[i--] = node;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }
        }
        if(i==-1)
            return ans;
        int[] temp = {};
        return temp;
    }
}