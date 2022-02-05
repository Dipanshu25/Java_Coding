/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class CandidateCode {

   static ArrayList<ArrayList<Integer>> findcombo(ArrayList<Integer> arr, int sum) {
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      ArrayList<Integer> temp = new ArrayList<>();

      Set<Integer> set = new HashSet<>(arr);
      arr.clear();
      arr.addAll(set);
      Collections.sort(arr);

      findNumbers(ans, arr, sum, 0, temp);
      return ans;
   }

   static void findNumbers(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int sum, int index, ArrayList<Integer> temp) {
      if (sum == 0) {
         ans.add(new ArrayList<>(temp));
         return;
      }
      for (int i=index;i<arr.size();i++) {
         if((sum-arr.get(i)) >= 0) {
            temp.add(arr.get(i));
            findNumbers(ans,arr,sum-arr.get(i),i,temp);
            temp.remove(arr.get(i));
         }
      }
   }


   public static void main(String args[] ) throws Exception {

	//Write code here

   ArrayList<Integer> arr = new ArrayList<>();
   arr.add(1);
   arr.add(2);
   arr.add(5);

   Scanner sc = new Scanner(System.in);
   int sum = sc.nextInt();
   
   int count = 0;

   ArrayList<ArrayList<Integer>> ans = findcombo(arr,sum);

   if(ans.size() == 0) {
      System.out.println();
      return;
   }   

   for (int i=0;i<ans.size();i++) {
      int x = 0;
      int y = 0;
      int z = 0;
      for (int j=0;j<ans.get(i).size();j++) {
         int getdvalue = ans.get(i).get(j);
         switch(getdvalue){
             case 1: x++; break;
             case 2: y++; break;
             case 5: z++; break;
         }
         
      }
      
      if (x>y && y>z && x!=0 && y!=0 && z!=0){
             count++;
         }
   }
   
   System.out.print(count);

   }
}
