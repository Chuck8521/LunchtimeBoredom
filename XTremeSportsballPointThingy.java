//2007 - 6

import java.util.*;

public class XTremeSportsballPointThingy{

  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int times = input.nextInt();
    
    for(int i = 0; i < times; i++){
       
       int points = input.nextInt();
       
       if(points == 0){
         System.out.println("0 points: 1 ways");
         continue;
       } else if (points < 0){
         System.out.println(points + " points: 0 ways");
         continue;
       }
       
       ArrayList<String> allSets = new ArrayList<String>();
       //We have a positive integer. Do stuff with it
       int num3s = 0;
       for(int x = points; x > 0; x -= 3){
         int num2s = 0;
         for(int y = x; y > 0; y -= 2){
           int num1s = 0;
           for(int z = y; z > 0; z--){
             num1s++;
           }
           //I know here how many numbers of each are in this set - I need to find the number of unique permutations I can make
           ArrayList<Integer> set = new ArrayList<Integer>();
           for(int a = 0; a < num1s; a++){
             set.add(1);
           }
           for(int a = 0; a < num2s; a++){
             set.add(2);
           }
           for(int a = 0; a < num3s; a++){
             set.add(3);
           }
           
           for(int a = 0; a < set.size(); a++){
             int current = set.get(0);
             for(int b = 0; b < set.size(); b++){
               set.remove(b);
               if(b == set.size()){
                  set.add(current);
               } else {
                  set.add(b + 1, current);
               }
               //Convert to String because ArrayList deep copies are hard
               String test = "";
               for(int c = 0; c < set.size(); c++){
                  test += set.get(c);
               }
               if(!allSets.contains(test)){
                  allSets.add(test);
               }
             }
           }
           
           num2s++;
         }
         num3s++;
       }
      
     System.out.println(points + " points: " + allSets.size() + " ways");
      
    }
  }
}
