import java.util.*;

public class HolidayCode1 {

  public static void main(String[] args){
	  

    Scanner input = new Scanner(System.in);
    String rawIn = input.nextLine();
    String[] singleDirections = rawIn.split(", ");
    int direction = 1; //1 = N, 2 = E, 3 = S, 4 = W
    
    ArrayList<Integer> xs = new ArrayList<Integer>();
    ArrayList<Integer> ys = new ArrayList<Integer>();
           
    xs.add(0);
    ys.add(0);
    
    for(int i = 0; i < singleDirections.length; i++){
    	
    	//System.out.print(i);
     
	  int currentNS = ys.get(ys.size() - 1);
      int currentEW = xs.get(xs.size() - 1);
	    
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
    	  System.out.println("This shouldn't happen.");
      }
      
      int number = Integer.parseInt(current.substring(1));
      if(direction == 4){
        //currentEW -= number;
        for(int j = 0; j < number; j++){
        	currentEW--;
        	int currentX = currentEW;
            int currentY = currentNS;
            
            for(int k = 0; k < xs.size(); k++){
          	   if(currentX == xs.get(k)){
          		  if(ys.get(k) == currentY){
          			  System.out.println("This is the location: " + currentEW + ", " + currentNS);
              		  System.out.println(currentNS + currentEW);
          			  return;  
          		  }
          	  }        
            }
            
            xs.add(currentX);
            ys.add(currentY);
        }
      } else if (direction == 1){
        //currentNS += number; 
    	  for(int j = 0; j < number; j++){
          	currentNS++;
          	int currentX = currentEW;
              int currentY = currentNS;
              
              for(int k = 0; k < xs.size(); k++){
            	  int testX = xs.get(k);
            	  if(currentX == testX){
            		  if(ys.get(k) == currentY){
            			  System.out.println("This is the location: " + currentEW + ", " + currentNS);
                		  System.out.println(currentNS + currentEW);
            			  return;  
            		  }
            	  }        
              }
              
              xs.add(currentX);
              ys.add(currentY);
          }
      } else if (direction == 2){
        //currentEW += number; 
    	  for(int j = 0; j < number; j++){
          	currentEW++;
          	//System.out.println(currentEW);
          	int currentX = currentEW;
              int currentY = currentNS;
              
              for(int k = 0; k < xs.size(); k++){
            	  int testX = xs.get(k);
            	  if(currentX == testX){
            		  if(ys.get(k) == currentY){
            			  System.out.println("This is the location: " + currentEW + ", " + currentNS);
                		  System.out.println(currentNS + currentEW);
            			  return;  
            		  }
            	  }        
              }
              
              xs.add(currentX);
              ys.add(currentY);
          }
      } else if (direction == 3){
        //currentNS -= number; 
    	  for(int j = 0; j < number; j++){
          	currentNS--;
          	int currentX = currentEW;
              int currentY = currentNS;
              
              for(int k = 0; k < xs.size(); k++){
            	  int testX = xs.get(k);
            	  if(currentX == testX){
            		  if(ys.get(k) == currentY){
            			  System.out.println("This is the location: " + currentEW + ", " + currentNS);
                		  System.out.println(currentNS + currentEW);
            			  return;  
            		  }
            	  }        
              }
              
              xs.add(currentX);
              ys.add(currentY);
          }
      } else {
    	  System.out.println("That should't happen.");
      }
    
            
    }
    
    
  }
   
}
