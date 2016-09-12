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
       
       //We have a positive integer. Do stuff with it
       
       
    }
  }
}
