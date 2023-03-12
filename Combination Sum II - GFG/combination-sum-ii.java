//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] candidates = new int[n];
            for (int i = 0; i < n; i++) candidates[i] = sc.nextInt();

            Solution obj = new Solution();
            List<List<Integer>> ans = obj.combinationSum2(candidates, k);
            Collections.sort(ans, new Comparator<List<Integer>>() {
                @Override   public int compare(List<Integer> a, List<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            System.out.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.print("]");
            }
            System.out.println(" ]");
        }
    }
}
// } Driver Code Ends

class Solution {
   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates,0,0,target,list,ans);
        return ans;
    }
    void backtrack(int[] arr,int idx,int sum,int tar,List<Integer> list,List<List<Integer>> ans){
        if(sum==tar){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum>tar)
            return;
        for(int i=idx;i<arr.length;i++){
            if(i>idx&&arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
            backtrack(arr,i+1,sum+arr[i],tar,list,ans);
            list.remove(list.size()-1);
        }
    }
}