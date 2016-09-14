//2006 - 6

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
        
        ArrayList<Integer> parentsOfStart = new ArrayList<Integer>(); 
        ArrayList<Integer> parentsOfEnd = new ArrayList<Integer>(); 
        
        //Zero-based indexing
        int start = rawStart - 1;
        int end = rawEnd - 1;
        
        boolean go = true;
        while(go){
          parentsOfStart.add(parentOf[start]);
          start = parentOf[start];
          if(parentOf[start] == 0){
            go = false;
          }
        }
        
        go = true;
        while(go){
          parentsOfEnd.add(parentOf[end]);
          end = parentOf[end];
          if(parentOf[end] == 0){
            go = false;
          }
        }
        
        //Find first place where arrays converge TODOTODOTODOTODOTODOTODOTODOTODOTODOTODOTODOTODOTODOTODOTODOTODOTODOTODOTODO
        for(int j = 0; j < parentsOfStart.size(); j++){
          for(int v = 0; v < parentsOfEnd.size(); v++){
            if(parentsOfStart.get(j) == parentsOfEnd.get(v)){
              //Switch array of focus
            }
          }
        }
        
      }
      
    }
