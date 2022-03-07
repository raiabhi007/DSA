class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms,visited,0);
        
        for(int i=0;i<rooms.size();i++){
            if(visited[i]==false)
                return false;
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms,boolean[] visited,int src){
        visited[src] = true;
        
        for(int i:rooms.get(src)){    
            if(visited[i]==false)
                dfs(rooms,visited,i);
        }
    }
}