//2008 - 3

import java.util.*;

public class RiemannSums {

  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int times = input.nextInt();
    
    for(int i = 0; i < times; i++){
      
      String rawIn = inputString.nextLine();
      String[] rawDoubs = rawIn.split(" ");
      double a = Double.parseDouble(rawDoubs[0]);
      double b = Double.parseDouble(rawDoubs[1]);
      int rawM = Integer.parseInt(rawDoubs[2]);
      int k = Integer.parseInt(rawDoubs[3]);
      ArrayList<Integer> coefs = new ArrayList<Integer>();
      
      for(int x = 4; x <= k + 4; x++){
        coefs.add(Double.parseDouble(rawDoubs[x]));
      }
      
      //Maths and logics
      double m = (double) rawM;
      double rectWidth = (b - a)/m;
      
      //Pick up here
      
    }
    
  }
  
}
