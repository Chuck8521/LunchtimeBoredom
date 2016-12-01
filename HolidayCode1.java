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
    
    ArrayList<Point> points = new ArrayList<Point>();
    
    Point start = new Point(0,0);
    points.add(start);
    
    for(int i = 0; i < singleDirections.length; i++){
     
	  int currentNS = start.y;
      int currentEW = start.x;
	    
      String current = singleDirections[i];
     
      if(current.charAt(0) == 'R'){       
    	  if(direction == 4){
    		  direction = 1;
    	  } else {
    		  direction++;  
    	  }
      } else if(current.charAt(0) == 'L'){
    	  if(direction == 1){
    		  direction = 4;
    	  } else {
    		  direction--;
    	  }
      } else {
    	  System.out.println("BUG FOUND");
      }
      
      int number = Integer.parseInt(current.substring(1));
      if(direction == 4){
        currentEW -= number; 
      } else if (direction == 1){
        currentNS += number; 
      } else if (direction == 2){
        currentEW += number; 
      } else if (direction == 3){
        currentNS -= number; 
      } else {
    	  System.out.println("HELP PLZ");
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
    
    
  }
   
}
