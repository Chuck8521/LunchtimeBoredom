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
      
      //Argh it be the math
      
      
    
    }
  
  }

}
