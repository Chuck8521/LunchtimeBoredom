import java.util.*;
import java.io.*;

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
	
  @Override
  public int compare(Node n1, Node n2) {
	  //TODO AHHHHHHHHHHHHHHHHHHHHHHH HARD CODED
      return n1.gCost(new Point(1,4)) - n2.gCost(new Point(1,4));
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
  
  //@Override
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
  
  public boolean isGoal(Point end){
	  if((end.getX() == state.getX()) && (end.getY() == state.getY())){
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public int gCost(Point end){
    return cost + state.getManhattenDist(end);
  }
  
  public ArrayList<Node> allPossibleMoves(boolean[][] board){
    ArrayList<Node> moves = new ArrayList<Node>();
    //Check to see if Points above below left and right are open, or if there is a wall TODO Loop this
    if(!board[state.getX()][state.getY() + 1]){
      Point temp = new Point(state.getX(), state.getY() + 1);
      ArrayList<Point> tempList = new ArrayList<Point>(path);
      tempList.add(temp);
      Node above = new Node(tempList, temp, cost + 1);
      moves.add(above);
      //path.remove(path.size() - 1);//Takes last element(what we just added) out
    }
    if(!board[state.getX()][state.getY() - 1]){//WARNING - Works only when walls border everything on all sides
      Point temp = new Point(state.getX(), state.getY() - 1);
      ArrayList<Point> tempList = new ArrayList<Point>(path);
      tempList.add(temp);
      Node below = new Node(tempList, temp, cost + 1);
      moves.add(below);
      //path.remove(path.size() - 1);//Takes last element(what we just added) out
    }
    if(!board[state.getX() - 1][state.getY()]){
      Point temp = new Point(state.getX() - 1, state.getY());
      ArrayList<Point> tempList = new ArrayList<Point>(path);
      tempList.add(temp);
      Node left = new Node(tempList, temp, cost + 1);
      moves.add(left);
      //path.remove(path.size() - 1);//Takes last element(what we just added) out
    }
    if(!board[state.getX() + 1][state.getY()]){
      Point temp = new Point(state.getX() + 1, state.getY());
      ArrayList<Point> tempList = new ArrayList<Point>(path);
      tempList.add(temp);
      Node right = new Node(tempList, temp, cost + 1);
      moves.add(right);
      //path.remove(path.size() - 1);//Takes last element(what we just added) out
    }
    
    return moves;
  }
  
}

class SearchAlgorithms {

  public static void main(String[] args){
    //Add code to select method of search
    //For now, just A* graph search
    //Read each line. A 1 = a wall (true). A 0 = an open space. TODO - Add support for different costs?
    try{
      File file = new File("maze.txt");
	   FileReader fileReader = new FileReader(file);
	   BufferedReader input = new BufferedReader(fileReader);
      //The first line of the file must be a number representing n (where the n * n maze follows on the next n lines)
      String raw = input.readLine();
      int n = Integer.parseInt(raw);
      
      boolean[][] board = new boolean[n][n];
      
      Point startState = null;
      Point endState = null;
      
      //The next n lines contain 0s and 1s with no spaces between, representing the maze. ex 1000101010000101101
      //Start Point = S, End Point = F
      for(int i = 0; i < n; i++){
        String line = input.readLine();
        for(int x = 0; x < line.length(); x++){
           char number = line.charAt(x);
           if(number == '0'){
              //Put false in array
              board[i][x] = false;//TODO What if I can switch it so the output isn't weird and rotated due to x and y switching places?
           } else if (number == '1'){
              //Put true in array
              board[i][x] = true;
           } else if (number == 'S'){
              startState = new Point(i,x);
              board[i][x] = false;
           } else if (number == 'F'){
              endState = new Point(i,x);
              board[i][x] = false;
           }
        }
      }
    
      if(startState != null && endState != null){
   
        ArrayList<Point> solution = AStarGraphSearch(startState, endState, board);
        if(solution == null){
          System.out.println("failure"); 
        } else {
          System.out.println("success");
          for(Point p : solution){
             //Convert to our humanoid Cartesian standard
             System.out.println("(" + (p.getY() + 1) + "," + (p.getX() + 1) + ")");
          } 
        }
      
      } else {
        System.out.println("There is a problem with your input file. Please make sure you have a start point (S) and end point (F)");
      }
    
    } catch (IOException error) { //Need this for using buffered readers
			error.printStackTrace();
	 }

    
  }
  
  
  
  public static ArrayList<Point> AStarGraphSearch(Point startState, Point end, boolean[][] board){
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
      if(test.isGoal(end)){
        //Solution found!
        //Return path to main method
        return test.getPath();
      }
      //if current state not in closed set then
      if(!closed.contains(test.getCurrentState())){
        //add the node to closed
        closed.add(test.getCurrentState());
        //foreach child node of the current state
        ArrayList<Node> children = test.allPossibleMoves(board);
        for(Node n : children){
          //insert the node into the fringe
          fringe.add(n);
        }
      }
      
    }
  }


}
