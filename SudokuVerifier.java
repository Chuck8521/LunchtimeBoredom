//2007 - 5

import java.util.*;

public class SudokuVerifier{

  public static void main(String[] args){
  
      Scanner input = new Scanner(System.in);
      Scanner inputString = new Scanner(System.in);
      int times = input.nextInt();
    
      for(int i = 0; i < times; i++){
        boolean viable = true;
        boolean incomplete = false;
      
        int[][] board = new int[9][9];
        for(int x = 0; x < 9; x++){
          String raw = inputString.nextLine();
          String[] rawNums = raw.split(" ");
          for(int j = 0; j < 9; j++){
            board[x][j] = Integer.parseInt(rawNums[j]);
            //Check for repetition in row here rather than later
            for(int q = j + 1; q < 9; q++){
              if(rawNums[q].equals(rawNums[j])){
                viable = false;
              } else if (rawNums[q].equals("0") || rawNums[j].equals("0")){
                incomplete = true;
              }
            }
          }
        }
        
        //Check for column repetition
        for(int x = 0; x < 9; x++){
          for(int j = 0; j < 9; j++){
            for(int k = j + 1; k < 9; k++){
              if(board[x][j] == board[x][k]){
                viable = false;
              }
            }
          }
        }
        
        //Check for submatrix repetition
        for(int x = 0; x < 9; x + 3){
         for(int j = 0; j < 9; j + 3){
           //[x][j] is always top left of submatrix
           for(int k = x; k < x + 3; k++){
             for(int q = j; q < j + 3; q++){
               for(int y = k + 1; y < x + 3; y++){
                 for(int v = q + 1; v < j + 3; v++){
                   if(board[k][q] == board[y][v]){
                     viable = false;
                   }
                 }
               }
             }
           }
         } 
        }
        
        if(viable && !incomplete){
          System.out.println("complete")
        } else if (viable){
          System.out.println("incomplete but viable")
        } else {
          System.out.println("non-viable")//TODO
        }
        
      
      }
      
    }
    
}
