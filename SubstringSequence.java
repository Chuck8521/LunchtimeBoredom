//1998 - 3

import java.util.*;

public class SubstringSequence{

  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    
    while(true){
    
      System.out.print("Enter S: ");
      String big = inputString.nextLine();
      System.out.print("Enter T: ");
      String small = inputString.nextLine();
      if(big.equals("") && small.equals("")){
        break;
      }
      
      String[] letters = big.split("");
      Arraylist<String> tests = small.split("");
      int start = 81;
      int end = 0;
      boolean valid = true;
      for(int i = 0; i < 0; i < letters){
        String test = tests.get(0);
        if(test.equals(letters[i])){
          //Match
          if(i < start){
            start = i + 1;
          }
          tests.remove(0);
          if(tests.size() == 0){
            end = i + 1;
            valid = false;
            break;
          }
        }
      }
      
      if(valid){
        System.out.println(start + " " + end);
      } else {
        System.out.println("0");
      }
      
    }
    
  }
  
}
