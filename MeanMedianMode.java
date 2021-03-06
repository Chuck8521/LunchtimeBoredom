//2005 - #3

import java.util.*;

public class MeanMedianMode {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int times = input.nextInt();

    for(int i = 0; i < times; i++){
      
      int size = input.nextInt();//THIS CAN EXCEED INT VALUES: PROBABLY NOT GOOD
      ArrayList<Integer> nums = new ArrayList<Integer>();
      int sum = 0;
      for(int x = 0; x < size; x++){
        int temp = input.nextLine();
        sum += temp;
        nums.add(temp);
      }
      
      double average = (double) temp / (double) size;
      System.out.println("Mean: " + average);
      
      //Median
      Collections.sort(nums);
      int index = nums.size();
      if(index % 2 == 0){
       //Two medians
        System.out.println("Median(s): " + nums.get(index/2) + " " + nums.get((index/2) - 1));
      } else {
        System.out.println("Median(s): " + nums.get(index/2));
      }

      //Restriction is that numbers are between 0 and 99. Use the hint
      int high = -1;
      ArrayList<Integer> mode = new ArrayList<Integer>();
      for(int x = 0; x <= 99; x++){
         int counter = 0;
         int test = nums.get(x);
         if(test == -1) continue;
         for(int j = x + 1; j <= 99; j++){
            if(test == nums.get(x)){
             counter++; 
              nums.set(j, -1);
            }
         }
        if(counter > high){
          high = counter; 
          mode.clear();
          mode.add(test);
        } else if {
          mode.add(test);
        }
        nums.set(x, -1);
      }
      
      
      
      System.out.print("Modes(s): ");
      for(int x = 0; x < mode.size(); x++){
        System.out.print(mode.get(x) + " "); 
      }
      System.out.println("(occurs " + high + " times)"); 
      
      
    }
    
  }
  
}
