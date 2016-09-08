//2008 - 4
//Input must be exact.

import java.util.*;

public class NextPermutation {

  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int times = input.nextInt();
    
    for(int i = 0; i < times; i++){
      
      int numElements = input.nextInt();
      String rawElements = inputString.nextLine();
      String[] stringElements = rawElements.split(" ");
      int[] elements = new int[stringElements.length];
      ArrayList<Integer> processed = new ArrayList<Integer>();
      
      for(int x = 0; x < stringElements.length; x++){
        elements[x] = Integer.parseInt(stringElements[x]);
      }
      
      for(int x = numElements - 1; x > 0; x--){
        
        if(elements[x] > elements[x - 1]){
          //We got the index
          //Switch [x-1] with whatever the next largest value in processed is
          int newValue = numElements;
          processed.add(elements[x]);
          for(int j = 0; j < processed.size(); j++){
            if(processed.get(j) > elements[x - 1] && processed.get(j) < newValue){
               newValue = processed.get(j);
              processed.set(j, elements[x - 1]);
            }
          }
          
          //We have the right arraylist now, so output
          Collections.sort(processed);//Is this right?
          for(int j = 0; j < elements.length; j++){
            System.out.print(elements[j] + " ");
          }
          System.out.println();
          for(int j = 0; j < x - 1; j++){
            System.out.print(elements[j] + " ");
          }
          System.out.print(newValue + " ");
          for(int j = 0; j < processed.size(); j++){
            System.out.print(processed.get(j) + " ");
          }
          System.out.println();
          System.out.println();
          break;
        } else {
          processed.add(elements[x]);
        }
        
      }
      
    }
    
  }
  
}
