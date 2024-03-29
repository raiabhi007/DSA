//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    public boolean isPossible(boolean [][] graph,int []color,int node,int col,int n){
        for(int i =0;i<n;i++){
            //if it is connected to another node and both colors are same
            if(graph[node][i] && color[i]==col)return false;
        }
        return true;
    } 
    public boolean solve(int node,boolean [][] graph,int []color,int m,int n){
        //if all node are coloured
        if(node ==n) return true; 
        //color this node with all possible color
        for(int i =1;i<=m;i++){
            //check whether it can be filled by color i
            if(isPossible(graph,color,node,i,n)){
                //if it can be filled,then color it
                color[node]=i;
                //color the next node
                if(solve(node+1,graph,color,m,n))return true;
                //if it can't be colored then we remove color
                color[node]=0;
            }
        }
        //if any one node are not coloured by 1 to m colors
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        //create a color array
        int []color = new int[n];
        //color the first node
        return solve(0,graph,color,m,n);
    }
}