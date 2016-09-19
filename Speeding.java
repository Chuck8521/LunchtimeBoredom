//1991 - #6

import java.util.*;

public class Speeding {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    while(true){
      System.out.print("Enter distance between checkpoints: ");
      double distance = input.nextDouble();
      if(distance == 0.0){
        break;
      }
      System.out.print("Enter time between checkpoints: ");
      double time = input.nextDouble();
      System.out.print("Enter speed limit: ");
      double speedLimit = input.nextDouble();
      
      speedLimit *= (5280.0/3600.0);
      
      if(speedLimit > (distance/time)){
        System.out.println("NOT SPEEDING");
      } else {
        System.out.println("SPEEDING");
      }
      
      System.out.println();
      
    }
    
  }
  
}
