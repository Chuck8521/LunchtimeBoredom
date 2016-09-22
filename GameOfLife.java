import java.util.*;

public class GameOfLife {

  public static void main(String[] args){
  
    //Current input reqs:
    //Line 1: n, where n is the number of lines of the n*n life array - n > 2
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
        
        int alive = 0;
        //The infinite wraparound grid method for extra funz - HARD CODED, COULD BE BAD BAD VERY BAD
        //Calculate alive in the if statement block, calculate next state outside
        if(i == 0 && x == 0){
          //Top left corner
          if(currentBoard[n - 1][n - 1] == 1){
           alive++; 
          }
          if(currentBoard[n - 1][0] == 1){
           alive++; 
          }
          if(currentBoard[n - 1][1] == 1){
           alive++; 
          }
          for(int v = 0; v < 2; v++){
            if(currentBoard[v][n - 1] == 1){
              alive++;
            }
            if(currentBoard[v][1] == 1){
              alive++;
            }
          }
          if(currentBoard[1][0] == 1){
              alive++;
          }
          
        } else if (i == 0 && x == n - 1){
          //Top right corner
          if(currentBoard[0][0] == 1){
           alive++; 
          }
          if(currentBoard[1][5] == 1){
           alive++; 
          }
          if(currentBoard[n - 1][n - 1] == 1){
           alive++; 
          }
          if(currentBoard[n - 1][n - 2] == 1){
           alive++; 
          }
          if(currentBoard[n - 1][0] == 1){
           alive++; 
          }
          if(currentBoard[1][0] == 1){
           alive++; 
          }
          for(int v = 0; v < 2; v++){
            if(currentBoard[v][4] == 1){
              alive++;
            }
          }
          if(currentBoard[1][0] == 1){
              alive++;
          }
        } else if (i == 0){
          //Top row
          for(int v = x - 1; v < n + 2; v++){
            if(currentBoard[n - 1][v] == 1){
              alive++; 
            }
          }  
          if(currentBoard[0][x - 1] == 1){
           alive++; 
          }
          if(currentBoard[0][x + 1] == 1){
           alive++; 
          }
          for(int v = x + 1; v < x + 2; v++){
            if(currentBoard[1][v] == 1){
              alive++; 
            }
          }
        } else if (x == 0 && i == n - 1){
          //Bottom left corner
          
          if(currentBoard[0][n - 1] == 1){
           alive++; 
          }
          if(currentBoard[n - 1][n - 1] == 1){
           alive++; 
          }
          if(currentBoard[n - 2][n - 1] == 1){
           alive++; 
          }
          if(currentBoard[n - 1][1] == 1){
           alive++; 
          }
          for(int v = 0; v < 2; v++){
            if(currentBoard[0][v] == 1){
              alive++;
            }
            if(currentBoard[n - 2][v] == 1){
              alive++;
            }
          }
          if(currentBoard[n - 2][n - 1] == 1){
              alive++;
          }
          
        } else if (x == 0){
          //Left side
          for(int v = i - 1; v < i + 2; v++){
            if(currentBoard[v][n - 1] == 1){
              alive++; 
            }
            if(currentBoard[v][x + 1] == 1){
              alive++; 
            }
          }  
          if(currentBoard[i - 1][x] == 1){
           alive++; 
          }
          if(currentBoard[i + 1][x] == 1){
           alive++; 
          }
          
        } else if (i == n - 1 && x == n - 1){
          //Bottom right corner
          
          if(currentBoard[n - 2][0] == 1){
              alive++;
          }
          if(currentBoard[0][0] == 1){
              alive++;
          }
          for(int v = n - 1; v > n - 3; v--){
            if(currentBoard[0][v] == 1){
                alive++;
            }
            if(currentBoard[n - 1][v] == 1){
                alive++;
            }
            if(currentBoard[n - 2][v] == 1){
                alive++;
            }
          }
          
        } else if (x == n - 1){
          //Right side
          for(int v = i - 1; v < i + 2; v++){
            if(currentBoard[v][0] == 1){
              alive++; 
            }
            if(currentBoard[v][x - 1] == 1){
              alive++; 
            }
          }  
          if(currentBoard[i - 1][x] == 1){
           alive++; 
          }
          if(currentBoard[i + 1][x] == 1){
           alive++; 
          }
          
        } else if (i == n - 1){
          //Bottom row
          for(int v = x - 1; v < n + 2; v++){
            if(currentBoard[0][v] == 1){
              alive++; 
            }
          }  
          if(currentBoard[n - 1][x - 1] == 1){
           alive++; 
          }
          if(currentBoard[n + 1][x + 1] == 1){
           alive++; 
          }
          for(int v = x - 1; v < x + 2; v++){
            if(currentBoard[n + 1][v] == 1){
              alive++; 
            }
          }
        } else {
          //Center
          //TODO
          
        }
      }
    }
    
    //Format output all nice and stuff
    
    
  }


}
