import java.util.*;

class Point {
	
	public int x;
	public int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}

public class HolidayCode1 {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    String rawIn = input.nextLine();
    String[] singleDirections = rawIn.split(", ");
    int direction = 1; //1 = N, 2 = E, 3 = S, 4 = W
    int N = 0;
    int E = 0;
    int S = 0;
    int W = 0;
    ArrayList<Point> points = new ArrayList<Point>();
    
    Point start = new Point(0,0);
    points.add(start);
    
    for(int i = 0; i < singleDirections.length; i++){
     
	  int currentNS = start.y;
      int currentEW = start.x;
	    
      String current = singleDirections[i];
     
      if(current.charAt(0) == 'R'){       
        direction++;
      } else {
        direction--;
      }
      
      int number = Integer.parseInt(current.substring(1));
      if(direction % 4 == 0){
        currentEW -= number; 
      } else if (direction % 4 == 1){
        currentNS += number; 
      } else if (direction % 4 == 2){
        currentEW += number; 
      } else {
        currentNS -= number; 
      }
    
      Point currentPoint = new Point(currentEW, currentNS);
      
      for(int k = 0; k < points.size(); k++){
    	  Point testPoint = points.get(k);
    	  if(currentEW == testPoint.x && currentNS == testPoint.y){
    		  System.out.println("This is the location: " + currentEW + ", " + currentNS);
    		  System.out.println(currentNS + currentEW);
			  return;
    	  }        
      }
      
      points.add(currentPoint);     
		start = currentPoint;
      
      
    }
    
    int absoluteNS = N - S;
    int absoluteEW = E - W;
    
    for(int j = 0; j < points.size(); j++){
    	System.out.print("(" + points.get(j).x + "," + points.get(j).y + ") ");
    }
    System.out.println("The Up-Down Coordinate is " + absoluteNS + " and the Left-Right Coordinate is " + absoluteEW);
    System.out.println(absoluteNS + absoluteEW);
    
  }
   
}
