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
          nums[x][y] = Integer.parseInt(letters[y]));
        }
      }
      
      //TODO
      
    
    }
    
  }
  
}
