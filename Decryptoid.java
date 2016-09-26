//Random riddle thing

import java.util.*;

public class Decryptoid {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    String in = input.nextLine();
    String output = "";
    
    for(int i = 0; i < in.length(); i++){
        
      char test = in.charAt(i);
       int value = test;
      if(Character.isLetter(test)){
        value += 2;
      }
      char temp = (char) value;
      output += temp;
      
    }
    
    System.out.println(output);
    
  }
  
}
