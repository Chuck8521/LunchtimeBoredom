//2005 - #6

import java.util.*;

public class ConvexPolygonRecognizer {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int times = input.nextInt();

    for(int i = 0; i < times; i++){
      int points = input.nextInt();
      ArrayList<Double> pointsX = new ArrayList<Double>();
      ArrayList<Double> pointsY = new ArrayList<Double>();
      for(int w = 0; w < points; w++){
        String raw = inputString.nextLine();
        String[] rawIn = raw.split(" ");
        double x = Double.parseDouble(rawIn[0]);
        double y = Double.parseDouble(rawIn[1]);
        pointsX.add(x);
        pointsY.add(y);
      }
      
      boolean convex = true;
      boolean leftTurn;
      for(int w = 0; w < points.size(); w++){
        int pastPoint;
        int nextPoint;
        if(w - 1 < 0){
          pastPoint = pointsX.size() - 1;
        } else if(w + 1 >= points.size()){
          nextPoint = 0;
        } else {
          pastPoint = w - 1;
          nextPoint = w + 1;
        }
        double rx = pointsX.get(pastPoint);
        double ry = pointsY.get(pastPoint);
        double qx = pointsX.get(w);
        double qy = pointsY.get(w);
        double px = pointsX.get(nextPoint);
        double py = pointsY.get(nextPoint);
        
        double result = ((rx*qy) - (py * rx) - (qx * qy) + (qx * py)) - ((qx * ry) - (px * ry) - (qx * qy) + (px * qy));
        
        if(w == 0){
          //First try, need to set leftTurn
          if(result > 0.0){
            //no leftTurn
            leftTurn = false;
          } else {
            //leftTurn
            leftTurn = true;
          }
        } else {
          if(result > 0.0){
            //no leftTurn
            if(leftTurn){
              convex = false;
            }
          } else {
            //leftTurn
            if(!leftTurn){
              convex = false;
            }
          }
        }
        
      }
      
      if(convex){
        System.out.println("convex");
      } else {
        System.out.println("not convex");
      }
      
    }
    
  }
  
}
