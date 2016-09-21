import java.util.*;

public class GameOfLife {

  public static void main(String[] args){
  
    //Current input reqs:
    //Line 1: n, where n is the number of lines of the n*n life array
    //Line 2: The 1st line of the life array (0 0 0 1 0 0 1 0)
    Scanner input = new Scanner(System.in);
    String in = input.nextLine();
    int n = integer.parseInt(in);
    
    //Current state
    int[][] currentBoard = new int[n][n];
    for(int i = 0; i < n; i++){
      String line = input.nextLine();
      String[] raw = line.split(" ");
      for(int x = 0; x < n; x++){
        currentBoard[i][x] = Integer.parseInt(raw[x]);
      }
    }
    
    //Next state
    int[][] nextBoard = new int[n][n];
    for(int i = 0; i < n; i++){
      for(int x = 0; x < n; x++){
        //Finds neighbors of each cell. If there are 1 or >=4, it dies. If 2 it remains the same. If three it is alive
        
        //The infinite wraparound grid method for extra funz
        if(i == 0 && x == 0){
          //Top left corner
        } else if (i == 0 && x == n - 1){
          //Top right corner
        } else if (i == 0){
          //Top row
        } else if (x == 0 && i == n - 1){
          //Bottom left corner
        } else if (x == 0){
          //Left side
        } else if (i == n - 1 && x == n - 1){
          //Bottom right corner
        } else if (x == n - 1){
          //Right side
        } else if (i == n - 1){
          //Bottom row
        } else {
          //Center
        }
      }
    }
    
    
    
    
  }


}
