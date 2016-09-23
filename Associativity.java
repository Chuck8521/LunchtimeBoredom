//2005 - #2

import java.util.*;

public class Associativity {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int times = input.nextInt();

    for(int i = 0; i < times; i++){
    
      int size = input.nextInt();
      ArrayList<Integer> nums = new ArrayList<Integer>();
      for(int x = 0; x < size; x++){
        String temp = inputString.nextLine();
        String[] letters = temp.split(" ");
        for(int y = 0; y < letters.length; y++){
          nums.add(Integer.parseInt(letters[y]));
        }
      }
      
      //TODO
    
    }
    
  }
  
}
