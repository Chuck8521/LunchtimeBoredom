//Random riddle thing

import java.util.*;

public class CharRarityAnalyzer {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    String in = input.nextLine();
    String output = "";
    
    ArrayList<Character> letters = new ArrayList<Character>();
    ArrayList<Integer> frequency = new ArrayList<Integer>();
    
    for(int i = 0; i < in.length(); i++){
        
      char test = in.charAt(i);
      if (!letters.contains(test)){
        letters.add(test);
        frequency.add(1);
      } else {
        frequency.set(letters.indexOf(test), frequency.get(letters.indexOf(test)) + 1);
      }
      
    }
    
    for(int i = 0; i < frequency.size(); i++){
      if(frequency.get(i) == 1){
        output += letters.get(i); 
      }
    }
    
    System.out.println(output);
    
  }
  
}
