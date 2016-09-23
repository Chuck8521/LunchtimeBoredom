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
      
      //TODO
      
    }
    
  }
  
}
