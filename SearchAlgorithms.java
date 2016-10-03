import java.util.*;

class Point{
  
  int x;
  int y;
  
  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }
  
  public int getX(){
    return x; 
  }
  
  public int getY(){
    return y; 
  }
  
  public int getManhattenDist(Point end){
    int dist = Math.abs(x - end.getX()) + Math.abs(y - end.getY());
    return dist; 
  }
  
}

class Node implements Comparator<Node>{
  
  List<Point> path = new ArrayList<Point>();
  Point state;
  int cost;
  
  public Node(ArrayList<Point> pathTo, Point currentState, int costTo){
    this.path = pathTo;
    this.state = currentState;
    this.cost = costTo;//TODO cost problems on the comparator?
  }
  
  @Override
  public Node(Point currentState){
    //First node
    this.state = currentState;
    this.cost = 0;
  }
  
  public Point getCurrentState(){
    return state; 
  }
  
  public int gCost(Point end){
    return state.getManhattenDist(end);
  }
  
  public int compare(Node n1, Node n2) {
      return n1.cost - n2.cost;
   }
  
}

class SearchAlgorithms {

  public static void main(String[] args){
    //Add code to select method of search
    //For now, just A* graph search
    Object startState;//TODO
    Object endState;//TODO
    ArrayList<Object> solution = A*GraphSearch(startState, endState);
    if(solution.size() == 0){
      System.out.println("failure"); 
    } else {
      System.out.println("success"); 
    }
  }
  
  
  
  public static ArrayList<Object> A*GraphSearch(Point startState, Point end){
    HashSet<Point> closed = new HashSet<Point>();
    PriorityQueue<Node> fringe = new PriorityQueue<Node>();
    Node start = new Node(startState);
    fringe.add(start);
    
    while(true){
    
      if(fringe.size() == 0){
        return fringe;//essentially an empty list
      }
      
      //Remove the next node based on the heuristic
      Node test = fringe.poll();
      //if goal test is satisfied, return solution
      if(test.gCost(end) == 0){
        //Solution found!
        //TODO return path to main method
      }
      //if current state not in closed set then
      if(!closed.contains(test.getCurrentState())){
        //add the node to closed
        closed.add(test.getCurrentState());
        //foreach child node of the current state
          //insert the node into the fringe
      }
      
    }
  }


}
