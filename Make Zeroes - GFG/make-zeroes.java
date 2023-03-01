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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            ob.MakeZeros(matrix);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution{
    public void  MakeZeros(int[][] matrix){
        int n = matrix.length, m = matrix[0].length;
        int i= 0, j = 0;
        int[][] tempMat = new int[n][m];
        Arrays.stream(tempMat).forEach(a -> Arrays.fill(a, -1));
        while(i<n && j<m){
            if(matrix[i][j] == 0){
                int sum = 0;
                if(i-1 >=0){
                    sum += matrix[i-1][j];
                    tempMat[i-1][j] = 0;
                }
                if(i+1 <n){
                    sum += matrix[i+1][j];
                    tempMat[i+1][j] = 0;
                }
                if(j-1 >=0){
                    sum += matrix[i][j-1];
                    tempMat[i][j-1] = 0;
                }
                if(j+1 <m){
                    sum += matrix[i][j+1];
                    tempMat[i][j+1] = 0;
                }
                tempMat[i][j] = sum;
            }
            j++;
            if(j == m){
                i++;
                j = 0;
            }
        }
        i=0;
        j=m-1;
        while(i<n && j>=0){
            if(tempMat[i][j] != -1){
                matrix[i][j] = tempMat[i][j];
            }
            j--;
            if(j < 0){
                i++;
                j = m-1;
            }
        }
    }
}