import java.util.*;
import java.io.*;

class NodeDepthComparator implements Comparator<Node>{
	
  @Override
  public int compare(Node n1, Node n2) {
	  //TODO This
      return n1.getPath().size() - n2.getPath.size();
   }
}

class Node {
	
	int assignedValue;
	
	public Node(){
		this.assignedValue = 0;
	}
 	
  public Node(int assigned){
    this.assignedValue = assigned;
  }
  
  
}

class SudokuSolver {

  public static void main(String[] args){
    //Read each line. 9X9 Sudoku Grid with known values written, 0 where values unknown. See sudoku.txt
    try{
      File file = new File("sudoku.txt");//TODO Actually make this
	    FileReader fileReader = new FileReader(file);
			BufferedReader input = new BufferedReader(fileReader);
      
      Node[][] board = new Node[9][9];

      //The next 9 lines contain 0s and assigned numbers in the sudoku problem
      for(int i = 0; i < 9; i++){
        String line = input.readLine();
        for(int x = 0; x < 9; x++){
           char number = line.charAt(x);
           if(number == '0'){
              board[i][x] = new Node();
           } else {
							board[i][x] = new Node(Integer.parseInt(number)); 
					 }
        }
      }
    
				
				Node[][] solution = DepthFirstSearch(board);
   			
      if(solution == null){
        System.out.println("failure"); 
      } else {
        System.out.println("success");
				for(Point p : solution){
           //Print entire solution TODO
           System.out.println();
        }
			}
    
    } catch (IOException error) { //Need this for using buffered readers
			error.printStackTrace();
	 }

    
  }
  
	public static ArrayList<Point> DepthFirstSearch (Node[][] board){
	
		//Go to the deepest node on the fringe first
		Comparator<Node> comparator = new NodeDepthComparator();
    PriorityQueue<Node> fringe = new PriorityQueue<Node>(1, comparator);
    fringe.add(start, end);
		
		while(true){
			
			if(fringe.size() == 0){
        return null;//essentially an empty list - this is tested for and called failure
      }
			
			//Remove the next deepest node
      Node test = fringe.poll();
      //if goal test is satisfied, return solution
      if(test.isGoal(end)){//TODOTODOTODOTODOTODOTODOTODOTODOTODO
        //Solution found!
        //Return path to main method
        return test.getPath();
      }
			
			//If not, expand all options and add them to the fringe
			//foreach child node of the current state
      ArrayList<Node> children = test.allPossibleMoves(board);
      for(Node n : children){
        //insert the node into the fringe
        fringe.add(n);
      }
      
			
		}
		
	}
  
 

}
