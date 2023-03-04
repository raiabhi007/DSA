//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] intervals){
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int prevStart = res.get(res.size()-1)[0];
            
            int curStart = intervals[i][0];
            if(curStart<=res.get(res.size()-1)[1]){
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],intervals[i][1]);
            }else
                res.add(intervals[i]);
        }
        int ans[][] = new int[res.size()][2];
        res.toArray(ans);
        return ans;
    }
}