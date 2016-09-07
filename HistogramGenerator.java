//2008 - #2
//Only works for numbers with one or two digits (includes 0 and the negatives).
//Adaptable for larger numbers, feel free to do so for an interesting challenge

import java.util.*;

public class HistogramGenerator {

  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int times = input.nextInt();
    
    for(int i = 0; i < times; i++){
      
      int total = input.nextInt();
      int numRuns = total / 20;
      if(total % 20 != 0){
        numRuns++;
      }
      
      //There are as many lines of input as numRuns. Throw everything in one ArrayList?
      ArrayList<Integer> nums = new ArrayList<Integer>();
      for(int x = 0; x < numRuns; x++){
        
        String in = inputString.nextLine();
        String[] strings = in.split(" ");
        for(int j = 0; j < strings.length; j++){
          nums.add(Integer.parseInt(strings[j]));
        }
        
      }
      
      int min = Collections.min(nums);//error?
      int max = Collections.max(nums);
      
      ArrayList<Integer> freq = new ArrayList<Integer>();
      
      for(int x = min; x <= max; x++){
         int frequency = 0;
         for(int q = 0; q < nums.size(); q++){
            if(nums.get(q) == x){
               frequency++;
            }
         }
         freq.add(frequency);
      }
      
      
      //PRINTING TIME
      int height = Collections.max(freq);
      for(int x = height; x > 0; x--){
        System.out.print(" ");
        for(int j = 0; j < freq.size(); j++){
          if(freq.get(j) == x){
            System.out.print("*  ");
            freq.set(j,x - 1);
          } else {
            System.out.print("   ");
          }
        }
        System.out.println();
      }
      
      //Asteriks printed. Do the number line and numbers
      System.out.print("-+");
      for(int x = min + 1; x <= max; x++){
        
        System.out.print("--+");
        
      }
      
      System.out.println();
      
      //Same thing, basically... bad practice? Nah, probably easiest way
      if(min < 10){
        System.out.print(" ");
      }
      for(int x = min; x <= max; x++){
        
        if(x >= 9){
          System.out.print(x + " ");
        } else {
          System.out.print(x + "  ");
        }
        
      }
      
      System.out.println();
      
      
    }
  
  }

}
