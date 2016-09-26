//Random riddle thing

import java.util.*;

public class Decryptoid {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    String in = input.nextLine();
    String output = "";
    
    for(int i = 0; i < in.length(); i++){
      
      char test = in.charAt(i);
      if(isLetter(test)){
        test + 2;
      }
      
      output += char;
      
    }
    
    System.out.println(output);
    
  }
  
}
