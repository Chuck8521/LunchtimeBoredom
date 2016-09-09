//2008 - 1

import java.util.*;

public class LookAndSayGenerator{

  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    Scanner inputS = new Scanner(System.in);
    int times = input.nextInt();
    
    for(int i = 0; i < times; i++){
    
      String rawIn = inputS.nextLine();
      String[] rawS = rawIn.split(" ");
      
      String seed = rawS[0];
      int numElements = Integer.parseInt(rawS[1]);
       
      System.out.print(seed + " ");
      
      for(int j = 1; j < numElements; j++){
        String newSeed = "";      
        int number = 1;
        for(int x = 0; x < seed.length(); x++){
      
          if(x == seed.length() - 1){
             //Last run
             newSeed += String.valueOf(number) + seed.charAt(x);//Take out String.valueOf and watch the chaos
             break;
          }
      
          char letter = seed.charAt(x);
          if(letter == seed.charAt(x + 1)){
             number++;
          }  else {
             newSeed += String.valueOf(number) + seed.charAt(x);
             number = 1;
          }
      
        }
        System.out.print(newSeed + " ");
        seed = newSeed;
      }
        
      System.out.println();
      
    }
  
  }

}
