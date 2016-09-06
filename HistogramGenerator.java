//2008 - #2

import java.util.*;

public class HistogramGenerator {

  public static main void(String[] args){
  
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
      for(int x = 0; x < runs; x++){
        
        String in = inputString.nextLine();
        String[] strings = in.split(" ");
        for(int j = 0; j < strings.length; j++){
          nums.add(Integer.parseInt(strings[j]);
        }
        
      }
      
      int min = Collections.min(nums);//error?
      int max = Collections.max(nums);
      
      ArrayList<Integer> number = new ArrayList<Integer>();
      ArrayList<Integer> freq = new ArrayList<Integer>();
      
      for(int x = 0; x < nums.size(); x++){
        int test = nums.get(x);
        if(test == -999999){//Don't think this will be used
          continue;
        }
        int frequency = 1;
        for(int j = x + 1; j < nums.size(); j++){
          int test2 = nums.get(j);
          if(test = test2){
            frequency++;
            nums.replace(j, -999999)
          }
        }
        number.add(test);
        freq.add(frequency;)
      }
      
      
      //PRINTING TIME
      int height = Collections.max(freq);
      for(int x = height; x > 0; x--){
        
        System.out.print()//TODO
        
      }
      
      
    }
  
  }

}
