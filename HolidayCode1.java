import java.util.*;

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
    
    for(int i = 0; i < singleDirections.length; i++){
     
      String current = singleDirections[i];
     
      if(current.charAt(0) == 'R'){       
        direction++;
      } else {
        direction--;
      }
      
      int number = Integer.parseInt(current.substring(1));
      if(direction % 4 == 0){
        W += number; 
      } else if (direction % 4 == 1){
        N += number; 
      } else if (direction % 4 == 2){
        E += number; 
      } else {
        S += number; 
      }
      
      int absoluteNS = N - S;
      int absoluteEW = E - W;
      
      System.out.println("The Up-Down Coordinate is " + absoluteNS + " and the Left-Right Coordinate is " + absoluteEW);
      
    }
    
  }
   
}
