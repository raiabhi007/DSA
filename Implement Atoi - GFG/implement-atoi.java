//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	int arr[] = new int[3];
	arr[2] = 1;
	helper(str,0,arr);
	if(arr[0]==-1)
	return arr[0];
	return arr[0]*arr[2];
    }
    void helper(String str,int i, int[] arr){
        if(i==0&&str.charAt(0)=='-'){
            i++;
            arr[2] = -1;
        }
        if(i==str.length()-1){
            if(str.charAt(i)<'0'||str.charAt(i)>'9'){
                arr[0] = -1;
                return;
            }
            arr[1] = 10;
            arr[0] = str.charAt(i)-'0';
            return;
        }
        if(str.charAt(i)<'0'||str.charAt(i)>'9'){
                arr[0] = -1;
            }
             if(arr[0]==-1)
              return;
        helper(str,i+1,arr);
        if(arr[0]==-1)
        return;
        arr[0] = (str.charAt(i)-'0')*arr[1]+arr[0];
        arr[1] = 10*arr[1];
    }
}
