import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {

 public static void main (String[] args) {

     Scanner sc = new Scanner (System.in);

     

     int k = sc.nextInt();

     for (int i=0; i<k; i++) {

         int s = sc.nextInt();

         LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

         for (int j=0; j<s; j++) {

             int n = sc.nextInt();

             map.put(n, map.getOrDefault(n, 0) + 1);

         }

         sort(map);

     }

     

     sc.close();

 }

 

 public static void sort (LinkedHashMap<Integer,Integer> map) {
     ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
     Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {
         @Override
         public int compare(Map.Entry<Integer,Integer> l, Map.Entry<Integer,Integer> r) {
             if (l.getValue()>r.getValue()) return -1;
             if (l.getValue()<r.getValue()) return 1;
             if (l.getValue()==r.getValue()){
                 if (l.getKey()>r.getKey()) return 1;
                 if (l.getKey()<r.getKey()) return -1;
             }
             return 0;
         }
     });
     map.clear();
     for (Map.Entry<Integer,Integer> e: list) {
         for (int i=0; i<e.getValue();i++) {
             System.out.print(e.getKey()+" ");
         }
     }
     System.out.println();
 }
}