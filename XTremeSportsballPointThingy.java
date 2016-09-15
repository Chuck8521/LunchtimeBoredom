//2007 - 6

import java.util.*;

public class SudokuVerifier{

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
       
       int ways = 0;
       //We have a positive integer. Do stuff with it
       for(int x = points; x > 0; x -= 3){
         for(int y = x; y > 0; y -= 2){
           int n = 0;
           for(int z = y; z > 0; z--){
             n++;
           }
           //Factoral n = (n!), and ways += n
           int factoral = 1;
           for(int v = 1; v <= n; v++){
             factoral *= v;
           }
         }
       }
       
       
    }
  }
}
