//2008 - 3
//InputFormatExceptions all over the place. It works when input is correct, and that's good enough for me.

import java.util.*;
import java.lang.Math;

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
      ArrayList<Double> coefs = new ArrayList<Double>();
      
      for(int x = 4; x <= k + 4; x++){
        coefs.add(Double.parseDouble(rawDoubs[x]));
      }
      
      //Maths and logics
      double m = (double) rawM;
      double rectWidth = (b - a)/m;
      
      double totalArea = 0.0;//Answer
      for(double x = 0; x < m; x ++){
        double leftXPoint = a + (rectWidth * x);
        //Find height, because we know width
        double yCoordinate = 0.0;
        for(int j = 0; j < coefs.size(); j++){
          double temp = coefs.get(j);
          temp *= Math.pow(leftXPoint, j);
          yCoordinate += temp;
        }
        
        //Have y, do stuff
        double area = yCoordinate * rectWidth;
        totalArea += area;
        
      }
      
      //OUTPUT TIME
      System.out.print("Estimated area under y = " + coefs.get(0) + "x^0");
      for(int x = 1; x < coefs.size(); x++){
        if(coefs.get(x) < 0.0){
          double posX = coefs.get(x) * -1;
          System.out.print(" - " + posX + "x^" + x);
        } else {
          System.out.print(" + " + coefs.get(x) + "x^" + x);
        }
        
      }
      System.out.println();
      
      System.out.println("   between x = " + a + " and x = " + b + " using " + rawM + " rectangles is " + totalArea);
      
    }
    
  }
  
}
