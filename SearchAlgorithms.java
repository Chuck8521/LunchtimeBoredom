import java.util.*;

class Node(){
  
  List<Object> path = new ArrayList<Object>();
  Object state;
  int cost;
  
  public Node(List<Object> pathTo, Object currentState, int costTo){
    this.path = pathTo;
    this.state = currentState;
    this.cost = costTo;
  }
  
}

class SearchAlgorithms {

  public static void main(String[] args){
    //Add code to select method of search
    //For now, just A* graph search
    Object startState;//TODO
    ArrayList<Object> solution = A*GraphSearch(startState);
  }
  
  public static ArrayList<Object> A*GraphSearch(Object startState){
    HashSet<Object> closed = new HashSet<Object>();
    ArrayList<Object> fringe = new ArrayList<Object>();
    fringe.add(startState);
    
    while(true){
    
      if(fringe.size() == 0){
        return fringe;//essentially an empty list
      }
      
      //Remove the next node based on the heuristic
      //TODO PriorityQueue?
      //if goal test is satisfied, return solution
      //if current state not in closed set then
        //add the node to closed
        //foreach child node of the current state
          //insert the node into the fringe
      
    }
  }


}
