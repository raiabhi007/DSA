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

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends

class Solution {
	public static int totalFruits(int N, int[] fruits) {
		int i = 0;
		int maxCount = 0;
		//Hash Map me only 2 type ke fruit lene hai... unki frequency store krni hai
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int j = 0; j < fruits.length; j++) {
		    //agr koi fruit mila jo map me nhi hai to i++ kro jbb tkk koi naya fruit aane ki space na bnn jaye
			if (!map.containsKey(fruits[j]) && map.size() >= 2) {
				while (map.size() != 1) {
					map.put(fruits[i], map.get(fruits[i]) - 1);
					if (map.get(fruits[i]) == 0) {
						map.remove(fruits[i]);
					}
					i++;
				}
			}
            //add new fruit to basket
			map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
			//hrr tree se ek hi fruit lena hai, to j-i+1 ka max hi maxfruit store hoga
			maxCount = Math.max((j - i + 1), maxCount);
		}
		return maxCount;
	}
}