//2008 - 6

import java.util.*;

public class DirectedGraph{

  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    Scanner inputS = new Scanner(System.in);
    int n = input.nextInt();
    String[][] matrix= new String[n][n];
    
    for(int i = 0; i < n; i++){
    
      String rawIn = inputS.nextLine();
      String[] oneLine = rawIn.split(" ");
      for(int x = 0; x < n; x++){
        matrix[i][x] = oneLine[x];
      }

    }
    
    int times = input.nextInt();
    for(int i = 0; i < times; i++){
      String rawIn = inputS.nextLine();
      String[] rawLine = rawIn.split(" ");
      int begin = Integer.parseInt(rawLine[0]);
      int end = Integer.parseInt(rawLine[1]);
      int distance = 0;
      ArrayList<Integer> beginStates = new ArrayList<Integer>();
      HashSet<Integer> inspectedStates = new HashSet<Integer>();
      beginStates.add(begin);
      boolean go = true;
      
      if(begin == end){
        System.out.println("distance from " + begin + " to " + end + " is " + distance);
        continue;
      }
      
      ArrayList<Integer> newBeginStates = new ArrayList<Integer>();
      
      //Do stuff
      while(go){
        distance++;
        for(int x = 0; x < beginStates.size(); x++){
          int tempState = beginStates.get(x);
          for(int j = 0; j < n; j++){
            if(matrix[tempState][j].equals("1")){
              if(j == end){
                //We got it
                System.out.println("distance from " + begin + " to " + end + " is " + distance);
                go = false;
                beginStates.clear();
                break;
              } else {
                //Not the end, but add it to newBeginStates
                newBeginStates.add(j);
              }
            }
          }
          
          inspectedStates.add(tempState);
          
        }
        
        beginStates.clear();
        for(int x = 0; x < newBeginStates.size(); x++){
          if(!beginStates.contains(newBeginStates.get(x))){
            beginStates.add(newBeginStates.get(x));
          }
        }
        newBeginStates.clear();
        
        boolean valid = false;
        for(int x = 0; x < beginStates.size(); x++){
          if(!inspectedStates.contains(beginStates.get(x))){
            valid = true;
          }
        }
        
        if(!valid && go){
          go = false;
          System.out.println("no path from " + begin + " to " + end);
          break;
        }
        
      }  
      
      
    }
    
    
  }
  
}

