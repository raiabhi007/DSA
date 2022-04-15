class Solution {
    public boolean canFinish(int numCourses, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
           int indegree[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][0]).add(arr[i][1]);
            indegree[arr[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        int cnt = 0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            cnt++;
            for(Integer it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }                
        }
        return cnt==numCourses;
    }
}