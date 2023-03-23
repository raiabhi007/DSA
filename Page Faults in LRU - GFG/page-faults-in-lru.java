//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int pages[]= new int[N];
            for(int i = 0; i < N; i++)
                pages[i] = Integer.parseInt(input_line[i]);
            int C = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.pageFaults(N, C, pages));
        }
    }
}

// } Driver Code Ends

class Solution{

    static int pageFaults(int N, int C, int pages[]){
        int page_fault = 0;
        Queue<Integer>q = new LinkedList<>();
        for(int i=0; i<N; i++){
            if(q.contains(pages[i])){
                q.remove(pages[i]);
                q.add(pages[i]);
            } 
            //when queue does not have the page[i] but we still have memory available
            else if(q.size() < C) {
                q.add(pages[i]);
                page_fault++;
            }
            //when queue does not have the page[i] but we don't have memory available
            else {
                q.poll();
                q.add(pages[i]);
                page_fault++;
            }
        }
        return page_fault;
    }
}