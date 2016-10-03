import java.util.*;

class SearchAlgorithms {

  public static void main(String[] args){
    //Add code to select method of search
    //For now, just A* graph search
    A*GraphSearch();
  }
  
  public static List<Object> A*GraphSearch(Object startState){
    HashSet<Object> closed = new HashSet<Object>();
    ArrayList<Object> fringe = new ArrayList<Object>();
    fringe.add(startState);
    
    while(true){
    
      if(fringe.size() == 0){
        return null;//Valid?
      }
      
      //Remove the next node based on the heuristic
      //if goal test is satisfied, return solution
      //if current state not in closed set then
        //add the node to closed
        //foreach child node of the current state
          //insert the node into the fringe
      
    }
  }


}
