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
       
       int ways = 1;
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
           ways += (num1s + num2s + num3s) * (num1s + num2s + num3s);
           num2s++;
         }
         num3s++;
       }
      
     System.out.println(points + " points: " + ways + " ways");
      
    }
  }
}
