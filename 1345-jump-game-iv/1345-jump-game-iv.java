class Solution {
      public int minJumps(int[] arr) {
        
        int n = arr.length;
        
        if(n<=1){
            return 0;
        }
        
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.putIfAbsent(arr[i],new HashSet<>());
            graph.get(arr[i]).add(i);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(0);
        
        int steps=0;
        
        while(!queue.isEmpty()){
            steps++;
            
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                
                int jump = queue.poll();
                
                // jump-1
                
                if(jump-1>=0&&graph.containsKey(arr[jump-1])){
                    queue.offer(jump-1);
                }
                
                // jump+1
                if(jump+1<n&&graph.containsKey(arr[jump+1])){
                    if(jump+1==n-1){
                        return steps;
                    }
                    queue.offer(jump+1);
                }
                
                if(graph.containsKey(arr[jump])){
                    
                    for(int k : graph.get(arr[jump])){
                        if(k!=jump){
                            if(k==n-1){
                                return steps;
                            }
                            queue.offer(k);
                        }
                    }
                }
                graph.remove(arr[jump]);
            }
        }
        return -1;
    }
}