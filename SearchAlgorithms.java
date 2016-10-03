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

class NodeComparator implements Comparator<Node>{
  public int compare(Node n1, Node n2) {
      return n1.gCost - n2.gCost;
   }
}

class Node {
  
  ArrayList<Point> path = new ArrayList<Point>();
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
    path.add(state);
    this.cost = 0;
  }
  
  public Point getCurrentState(){
    return state; 
  }
  
  public ArrayList<Point> getPath(){
    return path; 
  }
  
  public int gCost(Point end){
    return cost + state.getManhattenDist(end);
  }
  
  public ArrayList<Node> allPossibleMoves(boolean[][] board){
    ArrayList<Node> moves = new ArrayList<Node>();
    //Check to see if Points above below left and right are open, or if there is a wall TODO Loop this
    if(!board[state.getX()][state.getY() + 1]){
      Point temp = new Point(state.getX(), state.getY() + 1);
      path.add();
      Node above = (path, temp, cost + 1);
      moves.add(above);
      path.remove(path.size() - 1);//Takes last element(what we just added) out
    }
    if(!board[state.getX()][state.getY() - 1]){//WARNING - Works only when walls border everything on all sides
      Point temp = new Point(state.getX(), state.getY() - 1);
      path.add();
      Node below = (path, temp, cost + 1);
      moves.add(below);
      path.remove(path.size() - 1);//Takes last element(what we just added) out
    }
    if(!board[state.getX() - 1][state.getY()]){
      Point temp = new Point(state.getX() - 1, state.getY());
      path.add();
      Node left = (path, temp, cost + 1);
      moves.add(left);
      path.remove(path.size() - 1);//Takes last element(what we just added) out
    }
    if(!board[state.getX() + 1][state.getY()]){
      Point temp = new Point(state.getX() + 1, state.getY());
      path.add();
      Node right = (path, temp, cost + 1);
      moves.add(right);
      path.remove(path.size() - 1);//Takes last element(what we just added) out
    }
  }
  
}

class SearchAlgorithms {

  public static void main(String[] args){
    //Add code to select method of search
    //For now, just A* graph search
    /*Scanner input = new Scanner(System.in);
    int lines = input.nextInt();     TODO INPUT STUFFS, FOR NOW JUST HARD CODE - TRUE = WALL*/
    boolean[][] board = {{true, true, true, true, true, true, true}, {true, false, false, true, false, false, true}, {true, true, false, true, false, false, true}, {true, false, false, true, false, false, true}, {true, false, false, true, false, true, true}, {true, false, false, false, false, false, true}, {true, true, true, true, true, true, true}};
    Point startState = new Point(5,1);
    Point endState = new Point(0,5);
    ArrayList<Point> solution = A*GraphSearch(startState, endState, board);
    if(solution == null){
      System.out.println("failure"); 
    } else {
      System.out.println("success"); 
    }
  }
  
  
  
  public static ArrayList<Object> A*GraphSearch(Point startState, Point end, boolean[][] board){
    HashSet<Point> closed = new HashSet<Point>();
    Comparator<Node> comparator = new NodeComparator();
    PriorityQueue<Node> fringe = new PriorityQueue<Node>(1, comparator);
    Node start = new Node(startState);
    fringe.add(start);
    
    while(true){
    
      if(fringe.size() == 0){
        return null;//essentially an empty list? BAD PRACTICE TODO
      }
      
      //Remove the next node based on the heuristic
      Node test = fringe.poll();
      //if goal test is satisfied, return solution
      if(test.gCost(end) == 0){
        //Solution found!
        //Return path to main method
        return test.getPath();
      }
      //if current state not in closed set then
      if(!closed.contains(test.getCurrentState())){
        //add the node to closed
        closed.add(test.getCurrentState());
        //foreach child node of the current state
        ArrayList<Node> children = allPossibleMoves(board);
        for(Node n : children){
          //insert the node into the fringe
          fringe.add(n);
        }
      }
      
    }
  }


}
