class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        if(costs.length==1){
            return costs[0];
        }
        System.out.println(costs.length);
        int min1=0;
        int min2=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<costs.length;i++){
            list.add(costs[i]);
        }
        long cost=0;
        int win1=0;
        int win2=0;
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>();      
        if(candidates*2<=costs.length){  
            for(int i=0,j=costs.length-1;i<candidates;i++){
                pq1.add(costs[i]);
                pq2.add(costs[j]);
                win2=j;            
                j--;
                win1=i;              
            }
        }
        else{
            for(int i=0,j=costs.length-1;i<costs.length/2;i++){  
                pq1.add(costs[i]);
                pq2.add(costs[j]);
                win2=j;
                j--;
                win1=i;
            }
        }
        
        for(int i=0;i<k;i++){ 
         if(!pq1.isEmpty() && !pq2.isEmpty()){   
            min1=pq1.peek();
            min2=pq2.peek();
           
             if(min2<min1){  
                cost+=min2;
                pq2.remove();
                if(win1!=win2-1){ 
                    win2=win2-1;
                    pq2.add(costs[win2]);
                    
                }
                 
            }
            else{
                cost+=min1;
                pq1.remove();
                if(win1+1!=win2){ 
                    win1=win1+1;
                    pq1.add(costs[win1]);
                    
                }
            }
          
          }
          else if(!pq1.isEmpty()){ 
                cost+=pq1.remove();

          }
          else if(!pq2.isEmpty()){
                cost+=pq2.remove();
                
          }
          else{
                break;
          }
        }
        return cost;
    }
}