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
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> columns = new ArrayList<Integer>();
        ArrayList<Integer> subms = new ArrayList<Integer>();
      
        int[][] board = new int[9][9];
        for(int x = 0; x < 9; x++){
          String raw = inputString.nextLine();
          String[] rawNums = raw.split(" ");
          for(int j = 0; j < 9; j++){
            board[x][j] = Integer.parseInt(rawNums[j]);
            //Check for repetition in row here rather than later
            for(int q = j + 1; q < 9; q++){
              if(rawNums[q].equals(rawNums[j]) && !rawNums[q].equals("0")){
                viable = false;
                if(!rows.contains(x + 1)) rows.add(x + 1);//Because of 0-based indexing
              } else if (rawNums[q].equals("0") || rawNums[j].equals("0")){
                //Gets all incompletes, but still need to ignore zero later
                incomplete = true;
              }
            }
          }
        }
        
        //Check for column repetition
        for(int x = 0; x < 9; x++){
          for(int j = 0; j < 9; j++){
            for(int k = j + 1; k < 9; k++){
              if(board[x][j] == board[x][k] && board[x][j] != 0){
                viable = false;
                if(!columns.contains(x + 1)) columns.add(x + 1);
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
                   if(board[k][q] == board[y][v] && board[k][q] != 0){
                     viable = false;
                     if(x < 3 && j < 3){
                       if(!subms.contains(1)) subms.add(1); 
                     } else if (x < 3 && j < 6){
                       if(!subms.contains(4)) subms.add(4);
                     } else if (x < 3){
                       if(!subms.contains(7)) subms.add(7);
                     } else if (x < 6 && j < 3){
                       if(!subms.contains(2)) subms.add(2);
                     } else if (x < 6 && j < 6){
                       if(!subms.contains(5)) subms.add(5);
                     } else if (x < 6){
                       if(!subms.contains(8)) subms.add(8);
                     } else if (y < 3){
                       if(!subms.contains(3)) subms.add(3);
                     } else if (y < 6){
                       if(!subms.contains(6)) subms.add(6);
                     } else {
                       if(!subms.contains(9)) subms.add(9);
                     }
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
          System.out.print("  rows: ");
          for(int x = 0; x < rows.size(); x++){
            System.out.print(rows.get(x) + " ");
          }
          System.out.println();
          System.out.print("  columns: ");
          for(int x = 0; x < columns.size(); x++){
            System.out.print(columns.get(x) + " ");
          }
          System.out.println();
          System.out.print("  sub-matrices: ");
          for(int x = 0; x < subms.size(); x++){
            System.out.print(subms.get(x) + " ");
          }
          System.out.println();
        }
        
        inputString.nextLine();
      
      }
      
    }
    
}
