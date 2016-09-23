//2005 - #2

import java.util.*;

public class Associativity {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int times = input.nextInt();

    for(int i = 0; i < times; i++){
    
      int size = input.nextInt();
      int[][] nums = new int[size][size];
      for(int x = 0; x < size; x++){
        String temp = inputString.nextLine();
        String[] letters = temp.split(" ");
        for(int y = 0; y < letters.length; y++){
          int ascii = (int) letters[y];
          nums[x][y] = asci - 97;
        }
      }
      
      //TODO Test all letters and operations in the form (a @ a) @ a = a @ (a @ a)
      int firstTotal = 0;
      for(int v = 0; v < size; v++){
        for(int y = 0; y < size; y++){
          for(int x = 0; x < size; x++){
            int test = nums[y][x];
            int sum = nums[test][v];
            int otherWay = nums[x][v];
            int otherSum = nums[y][otherWay];
            if(sum != otherSum){
              System.out.println("not associative: " + )
            }
          }
        }
      }
    
    }
    
  }
  
}
