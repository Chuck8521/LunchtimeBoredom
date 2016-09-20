//2007 - #2

import java.util.*;

public class EgyptFractToFract {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int times = input.nextInt();

    for(int i = 0; i < times; i++){
    
      int numFractions = input.nextInt();
      String rawDenoms = inputString.nextLine();
      String[] raws = rawDenoms.split(" ");
      int[] denoms = new int[raws.length];
      int newDenom = 1;
      int numer = 0;
      for(int x = 0; x < raws.length; x++){
        denoms[x] = Integer.parseInt(raws[x]);
        newDenom *= denoms[x];
      }
      
      for(int x = 0; x < denoms.length; x++){
        numer += newDenom / denoms[x];;
      }
      
      //Reduce numer/newDenom
      for(int x = numer; x > 0; x--){
        if(newDenom % x == 0){
          newDenom /= x;
          numer = x;
        }
      }
      
      for(int x = 0; x < denoms.length; x++){
        if(x == denoms.length - 1){
          System.out.print("1/" + denoms[x] + " = ");
        }
        System.out.print("1/" + denoms[x] + " + ");
      }
      
      System.out.println(numer + "/" + newDenom);
      
    }
    
  }
  
}
