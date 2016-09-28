//2005 - #4

import java.util.*;

public class ThatDelicateBalance {

  public static double thatFunction(double num){
    //The function?
      double sum = 0.0;
        for(double x = 0.0; x <= num; x++){
          sum += Math.pow(3.0, x);
        }
        return sum;
  }

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    int times = input.nextInt();

    for(int i = 0; i < times; i++){
      
      int initialWeight = input.nextInt();
      int w = initialWeight;
      
      for(int j = 0; j < 20; j++){
        if((thatfunction(j) < Math.abs(w)) && thatfunction(j + 1) > Math.abs(w)){
          //We have the j we're looking for
          //TODO
        }
      }
      
    }
    
  }
   
}
