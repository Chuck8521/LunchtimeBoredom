//2006 - 4

import java.util.*;

public class LargePlantlikeStructure{

  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    Scanner inputS = new Scanner(System.in);
    int n = input.nextInt();
    
    for(int i = 0; i < n; i++){
      
      int nodes = input.nextInt();
      String raw = inputS.nextLine();
      String[] rawNums = raw.split(" ");
      int[] parentOf = new int[nodes];
      for(int x = 0; x < nodes; x++){
        parentOf[x] = Integer.parseInt(rawNums[x]);
      }
      
      int pairs = input.nextInt();
      for(int x = 0; x < pairs; x++){
        String temp = inputS.nextLine();
        String[] tempArray = temp.split(" ");
        int rawStart = Integer.parseInt(tempArray[0]);
        int rawEnd = Integer.parseInt(tempArray[1]);
        
        if(rawStart == rawEnd){
          System.out.println("path from " + rawStart + " to " + rawEnd + ": " + rawEnd);
          continue;
        }
        
        ArrayList<Integer> parentsOfStart = new ArrayList<Integer>(); 
        ArrayList<Integer> parentsOfEnd = new ArrayList<Integer>(); 
        
        //Zero-based indexing
        int start = rawStart - 1;
        int end = rawEnd - 1;
        
        parentsOfStart.add(rawStart);
        while(true){
          if(start < 0){
            break;
          }
          parentsOfStart.add(parentOf[start]);
          start = parentOf[start] - 1;
        }
        
        parentsOfEnd.add(rawEnd);
        while(true){
          if(end < 0){
            break;
          }
          parentsOfEnd.add(parentOf[end]);
          end = parentOf[end] - 1;
        }
        
        //Find first place where arrays converge
        int converge = 0;
        System.out.print("path from " + rawStart + " to " + rawEnd + ": ");
        for(int j = 0; j < parentsOfStart.size(); j++){
          System.out.print(parentsOfStart.get(j) + " ");
          if(parentsOfEnd.contains(parentsOfStart.get(j))){
            //This is the convergent point - break loop
            converge = parentsOfStart.get(j);
            break;
          }
        }
        
        //Warning: element might not be found, in which case -1 is returned and loop will not execute
        for(int j = parentsOfEnd.indexOf(converge) - 1; j >= 0; j--){
          System.out.print(parentsOfEnd.get(j) + " ");
        }
        System.out.println();
        
      }
      
    }
  }
}
