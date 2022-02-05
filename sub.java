/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class CandidateCode {

   public static ArrayList<String> strPerm(String str, ArrayList<String> list) {
      int len = str.length();
      if(len==1) {
         list.add(str);
         return list;
      }

      list = strPerm(str.substring(0, len-1), list);
      int ls = list.size();
      char ap = str.charAt(len-1);
      for (int i=0;i<ls;i++) {
         String temp = list.get(i);
         int tl = temp.length();
         for (int j=0;j<=tl;j++) {
            list.add(temp.substring(0,j) + ap + temp.substring(j,tl));
         }
      }

      while(true) {
         String temp = list.get(0);
         if(temp.length()<len)
            list.remove(temp);
         else
            break;
      }
      
      Set<String> set = new HashSet<>(list);
      list.clear();
      list.addAll(set);
      
      return list;

   }

   public static void main(String args[] ) throws Exception {

	//Write code here
   Scanner sc = new Scanner(System.in);
   String str = sc.nextLine();

   if (str.length()>=1 && str.length()<=20) {
      ArrayList<String> list =  new ArrayList<>();

      list = strPerm(str,list);
    //   for(int i=0;i<list.size();i++){
    //     String tmp = list.get(i);
    //     char ch = tmp.charAt(0);
    //     if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
    //         list.remove(tmp);
    //     }
    //   }
    
    
      ArrayList<String> newlist =  new ArrayList<>();
      
      for(int i=0;i<list.size();i++){
        String vow = list.get(i);
        char ch = vow.charAt(0);
        if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' && ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U'){
            newlist.add(vow);
        }
      }
        
      System.out.println(newlist.size());
	    
   }

   }
}
