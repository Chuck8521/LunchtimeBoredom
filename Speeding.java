//1991 - #6

import java.util.*;

public class Speeding {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    while(true){
      System.out.println("Enter distance between checkpoints: ");
      double distance = input.nextDouble();
      if(distance == 0.0){
        break;
      }
      System.out.println("Enter time between checkpoints: ");
      double time = input.nextDouble();
      System.out.println("Enter speed limit: ");
      double speedlimit = input.nextDouble();
      
      speedLimit *= (5280.0/3600.0);
      
      if(speedLimit > (distance/time)){
        System.out.println("SPEEDING");
      } else {
        System.out.println("NOT SPEEDING");
      }
      
      System.out.println();
      
    }
    
  }
  
}
