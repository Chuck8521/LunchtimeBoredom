//2008 - 5

import java.util.*;

public class LineSegmentRotation{

  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    Scanner inputS = new Scanner(System.in);
    int times = input.nextInt();
    
    for(int i = 0; i < times; i++){
    
      String rawIn = inputS.nextLine();
      String[] rawS = rawIn.split(" ");
      double[] doubs = new double[rawS.length];
      
      for(int x = 0; x < rawS.length; x++){
        doubs[x] = Double.parseDouble(rawS[x]);
      }
      
      double x1 = doubs[0];
      double y1 = doubs[1];
      double x2 = doubs[2];
      double y2 = doubs[3];
      
      //Arrr it be the math
      double xm = (x1 + x2) / 2.0;
      double ym = (y1 + y2) / 2.0;
      
      double changeX = x1 - xm;
      double changeY = y1 - ym;
      double firstX2 = xm + changeY;
      double firstY2 = ym + changeX;
      
      changeX = x2 - xm;
      changeY = y2 - ym;
      double secondX2 = xm + changeY;
      double secondY2 = ym + changeX;
      
      System.out.println("Rotating (" + x1 + "," + y1 + ")(" + x2 + "," + y2 + ") yields (" + firstX2 + "," + secondY2 + ")(" + secondX2 + "," + firstY2 + ")");
      
    
    }
  
  }

}
