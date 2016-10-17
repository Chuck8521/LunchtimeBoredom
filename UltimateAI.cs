using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class UltimateAI {


	public UltimateAI(){
		Debug.Log ("Init AI");
	}
		

	//Needs to return a button GameObject
	//nextMove is the board where you need to move next. -1 if anywhere (zero-based!)
	public GameObject move(int[,] smallBoards, int[] totalBoard, int nextMove, GameObject[] button1, GameObject[] button2, GameObject[] button3, GameObject[] button4, GameObject[] button5, GameObject[] button6, GameObject[] button7, GameObject[] button8, GameObject[] button9){
		//TODO Take care of anywhere and the time that would take on depth 4...
		Debug.Log ("AI's Move");

		State current = new State (smallBoards, totalBoard, nextMove, 2);//Should this be 2?
		//Calls agent 2, which is the maximizer (AI)
		List<State> allPossible = current.getAllMoves (current, 2);
		List<int> moveUtils = new List<int>();

		//In essence, this is the top maximizing node. So, when value is called, go MIN, MAX, MIN
		int maxPossible = -10001;
		for (int i = 0; i < allPossible.Count; i++) {
			//Get depth two
			maxPossible = Mathf.Max(maxPossible, value (allPossible [i], 4, 0, 1 ));//TODO This was one? Check 
			Debug.LogWarning("Current MaxPossible: " + maxPossible);
			moveUtils.Add (maxPossible);
		}

		State bestMove = allPossible[moveUtils.IndexOf (maxPossible)];//Should work because it returns the first
		Debug.LogWarning("Utility of picked state: " + bestMove.getValue());//TODO THIS IS GREATER THAN MAX POSSIBLE?
		//Determine which button needs to be pressed... and return. 
		//Just find the single discrepency between this state and current and you have it

		//We return this
		GameObject buttonToPress = new GameObject();

		int[,] newSmallBoards = bestMove.getSmallBoards();
		for(int i = 0; i < 9; i++){
			for (int x = 0; x < 9; x++) {
				if (smallBoards [i, x] != newSmallBoards [i, x]) {
					Debug.LogWarning ("In the assigning part!!!");
					if (i == 1) {
						buttonToPress = button2[x];
					} else if (i == 2) {
						buttonToPress = button3[x];
					} else if (i == 3) {
						buttonToPress = button4[x];
					} else if (i == 4) {
						buttonToPress = button5[x];
					} else if (i == 5) {
						buttonToPress = button6[x];
					} else if (i == 6) {
						buttonToPress = button7[x];
					} else if (i == 7) {
						buttonToPress = button8[x];
					} else if (i == 8) {
						buttonToPress = button9[x];
					} else {//0
						buttonToPress = button1[x];
					}
				}
			}
		}
		return buttonToPress;
	}


	//1 = min, 2 = max            allPossible[i], 4, 0, 1 are being passed first
	int value (State current, int maxDepth, int currentDepth, int agent){
		//if state at depth 2 or sure win, return utility
		if (currentDepth >= maxDepth || current.CheckForWinNo2DArray(current.getTotalBoard(), 1) || current.CheckForWinNo2DArray(current.getTotalBoard(), 2)) {
			return current.getValue();
		}

		//if next is max, return max-value
		if (agent == 2) {
			return maxValue (current, maxDepth, currentDepth, 2);
		}

		//if next is min, return min-value
		if (agent == 1) {
			return minValue (current, maxDepth, currentDepth, 1);
		}

		Debug.LogWarning ("ERROR RETURNING -30000!");
		return -30000;

	}


	int maxValue (State current, int maxDepth, int currentDepth, int agentNum){
		int v = -10000;
		//Switch agentNum
		int nextAgent;
		if(agentNum == 1){
			nextAgent = 2;
		} else {
			nextAgent = 1;	
		}
		foreach(State successor in current.getAllMoves(current, agentNum)){
			v = Mathf.Max(v, value(successor, maxDepth, currentDepth + 1, nextAgent));//WARNING: Mathf, not Math. Does it matter?
		}//each successor of state
		return v;
	}

	int minValue (State current, int maxDepth, int currentDepth, int agentNum){
		int v = 10000;
		//Switch agentNum
		int nextAgent;
		if(agentNum == 1){
			nextAgent = 2;
		} else {
			nextAgent = 1;	
		}
		foreach(State successor in current.getAllMoves(current, agentNum)){
			v = Mathf.Min(v, value(successor, maxDepth, currentDepth + 1, nextAgent));
		}//each successor of state
		return v;
	}

}

class State {

	int[,] smallBoards;
	int[] totalBoard;
	int nextMove;
	int agentNum;

	public State(int[,] smallBoards, int[] totalBoard, int nextMove, int agentNum){
		this.smallBoards = smallBoards;
		this.totalBoard = totalBoard;
		this.nextMove = nextMove;//WARNING: Must be zero-based
		this.agentNum = agentNum;
	}

	public int[,] getSmallBoards(){
		return (int[,])this.smallBoards.Clone();
	}

	public int getNextMove(){
		return this.nextMove;
	}

	public int[] getTotalBoard(){
		return (int[])this.totalBoard.Clone ();
	}


	//Agent: 1 = min, 2 = max
	public List<State> getAllMoves(State current, int agent){
		int board = current.getNextMove();
		int[] currentTotalBoard = current.getTotalBoard ();
		int[,] currentSmallBoards = current.getSmallBoards ();
		List<State> allPossibleMoves = new List<State>();
		if(board == -1){
			//Return every open square in squares not already won.
			for(int i = 0; i < 9; i++){
				if(currentTotalBoard[i] == 0){
					for(int x = 0; x < 9; x++){
						if(currentSmallBoards[i,x] == 0){
							int[,] tempSmall = (int[,]) currentSmallBoards.Clone();//TODO Organize
							tempSmall[i, x] = agent;
							int[] tempTotal = (int[]) currentTotalBoard.Clone();
							if(CheckForWin(tempSmall, i, agent)){//Instead of board being passed (-1), we pass the board number 
								tempTotal[i] = agent;
							}
							int tempMove = x;
							//AHHHHHHHHHHHHHHHHHH UNLESS x WOULD CAUSE THE NEXT AGENT TO GO ANYWHERE IN WHICH CASE IT WOULD BE -1
							if (tempTotal [x] != 0) {
								tempMove = -1;
							}
							int nextAgent = 1;
							if(agent == 1){
								nextAgent = 2;	
							}
							State possible = new State(tempSmall, tempTotal, tempMove, nextAgent);
							allPossibleMoves.Add(possible);
						}
					}
				}
			}
		} else {
			for(int i = 0; i < 9; i++){
				if(currentSmallBoards[board, i] == 0){
					//Open space = possible move!
					int[,] tempSmall = (int[,]) currentSmallBoards.Clone();
					tempSmall[board, i] = agent;
					int[] tempTotal = (int[]) currentTotalBoard.Clone();
					if(CheckForWin(tempSmall, board, agent)){
						tempTotal[board] = agent;
					}
					int tempMove = i;
					//AHHHHHHHHHHHHHHHHHH UNLESS i WOULD CAUSE THE NEXT AGENT TO GO ANYWHERE IN WHICH CASE IT WOULD BE -1
					if (tempTotal [i] != 0) {
						tempMove = -1;
					}
					int nextAgent = 1;
					if(agent == 1){
						nextAgent = 2;	
					}
					State possible = new State(tempSmall, tempTotal, tempMove, nextAgent);
					allPossibleMoves.Add(possible);
				}
			}
		}

		return allPossibleMoves;

	}

	public int getValue(){
		//Get utility score of this state
		int utility = 0;
		//We have access to smallBoards[,] and totalBoard[] 

		//Test for wins of either agent in totalBoard[]
		if(CheckForWinNo2DArray(totalBoard, 1)){
			return -10000;
		} else if(CheckForWinNo2DArray(totalBoard, 2)){
			return 9000;
		}

		//No one has won in this configuration. See what's actually going on in the metaboard first.
		//Center is weighted 3 (Metaboard weighted *3)
		//Corner 2
		//Side 1
		for (int i = 0; i < 9; i++) {
			if(totalBoard[i] == 1){
				if(i == 0 || i == 2 || i == 6 || i == 8){
					utility -= 4;//TODO WARNING THESE ARE UNTESTED AS OF NOW
				} else if(i == 1 || i == 3 || i == 5 || i == 7){
					utility -= 2;
				} else {//Center
					utility -= 6;
				}
			} else if (totalBoard[i] == 2){
				if(i == 0 || i == 2 || i == 6 || i == 8){
					utility += 2;
				} else if(i == 1 || i == 3 || i == 5 || i == 7){
					utility += 1;
				} else {//Center
					utility += 3;
				}
			}
		}

		//When there's two in a row, assign higher utility
		utility += potentialWinBonus(totalBoard);//TODO WARNING TESTIgnore two in a row if blocked already?

		//Everything before this point was metaboard and should be weighted double.
		utility *= 3;//WARNING: May need to increase

		//Analyze minor boards for position (center, corner, side) and having two in a row
		for(int i = 0; i < 9; i++){
			if(totalBoard[i] == 0){
				//Initialize array - it will be passed to the function later on to determine utility added by two in a row on the board
				int[] tempBoard = new int[9];
				for(int x = 0; x < 9; x++){
					tempBoard [x] = smallBoards [i, x];
					if(smallBoards[i, x] == 1){
						if(x == 0 || x == 2 || x == 6 || x == 8){
							utility -= 2;
						} else if(x == 1 || x == 3 || x == 5 || x == 7){
							utility -= 1;
						} else {//Center
							utility -= 3;
						}
					} else if (totalBoard[i] == 2){
						if(x == 0 || x == 2 || x == 6 || x == 8){
							utility += 2;
						} else if(x == 1 || x == 3 || x == 5 || x == 7){
							utility += 1;
						} else {//Center
							utility += 3;
						}
					}
				}

				//Check for two in a row
				utility += potentialWinBonus(tempBoard);

			}
		}


		return utility;		
	}

	//Convenience method for the utility function
	int potentialWinBonus(int[] totalBoard){
		int utility = 0;
		int agent = 2;//AI, so add
		//Need to test and make sure that the third one isn't blocked. If it is, just forget about it.
		if(((totalBoard[0] == agent && totalBoard [1] == agent) || (totalBoard[2] == agent && totalBoard [1] == agent)) || (totalBoard[2] == agent && totalBoard [0] == agent)){
			if (!(totalBoard [0] == 1 || totalBoard[1] == 1 || totalBoard[2] == 1)) {
				utility += 2;
			}
		}
		if(((totalBoard[0] == agent && totalBoard [3] == agent) || (totalBoard[0] == agent && totalBoard [6] == agent)) || (totalBoard[3] == agent && totalBoard [6] == agent)){
			if (!(totalBoard [0] == 1 || totalBoard[3] == 1 || totalBoard[6] == 1)) {
				utility += 2;
			}
		}
		if(((totalBoard[0] == agent && totalBoard [4] == agent) || (totalBoard[0] == agent && totalBoard [8] == agent)) || (totalBoard[4] == agent && totalBoard [8] == agent)){
			if (!(totalBoard [0] == 1 || totalBoard[4] == 1 || totalBoard[8] == 1)) {
				utility += 2;
			}
		}
		if(((totalBoard[3] == agent && totalBoard [4] == agent) || (totalBoard[3] == agent && totalBoard [5] == agent)) || (totalBoard[4] == agent && totalBoard [5] == agent)){
			if (!(totalBoard [3] == 1 || totalBoard[4] == 1 || totalBoard[5] == 1)) {
				utility += 2;
			}
		}
		if(((totalBoard[1] == agent && totalBoard [4] == agent) || (totalBoard[1] == agent && totalBoard [7] == agent)) || (totalBoard[4] == agent && totalBoard [7] == agent)){
			if (!(totalBoard [1] == 1 || totalBoard[4] == 1 || totalBoard[7] == 1)) {
				utility += 2;
			}
		}
		if(((totalBoard[6] == agent && totalBoard [7] == agent) || (totalBoard[7] == agent && totalBoard [8] == agent)) || (totalBoard[6] == agent && totalBoard [8] == agent)){
			if (!(totalBoard [6] == 1 || totalBoard[7] == 1 || totalBoard[8] == 1)) {
				utility += 2;
			}
		}
		if(((totalBoard[2] == agent && totalBoard [5] == agent) || (totalBoard[2] == agent && totalBoard [8] == agent)) || (totalBoard[5] == agent && totalBoard [8] == agent)){
			if (!(totalBoard [2] == 1 || totalBoard[5] == 1 || totalBoard[8] == 1)) {
				utility += 2;
			}
		}
		if(((totalBoard[2] == agent && totalBoard [4] == agent) || (totalBoard[2] == agent && totalBoard [6] == agent)) || (totalBoard[4] == agent && totalBoard [6] == agent)){
			if (!(totalBoard [2] == 1 || totalBoard[4] == 1 || totalBoard[6] == 1)) {
				utility += 2;
			}
		}



		agent = 1;//Player, so subtract
		if(((totalBoard[0] == agent && totalBoard [1] == agent) || (totalBoard[2] == agent && totalBoard [1] == agent)) || (totalBoard[2] == agent && totalBoard [0] == agent)){
			if (!(totalBoard [0] == 2 || totalBoard[1] == 2 || totalBoard[2] == 2)) {
				utility -= 2;
			}
		}
		if(((totalBoard[0] == agent && totalBoard [3] == agent) || (totalBoard[0] == agent && totalBoard [6] == agent)) || (totalBoard[3] == agent && totalBoard [6] == agent)){
			if (!(totalBoard [0] == 2 || totalBoard[3] == 2 || totalBoard[6] == 2)) {
				utility -= 2;
			}
		}
		if(((totalBoard[0] == agent && totalBoard [4] == agent) || (totalBoard[0] == agent && totalBoard [8] == agent)) || (totalBoard[4] == agent && totalBoard [8] == agent)){
			if (!(totalBoard [0] == 2 || totalBoard[4] == 2 || totalBoard[8] == 2)) {
				utility -= 2;
			}
		}
		if(((totalBoard[3] == agent && totalBoard [4] == agent) || (totalBoard[3] == agent && totalBoard [5] == agent)) || (totalBoard[4] == agent && totalBoard [5] == agent)){
			if (!(totalBoard [3] == 2 || totalBoard[4] == 2 || totalBoard[5] == 2)) {
				utility -= 2;
			}
		}
		if(((totalBoard[1] == agent && totalBoard [4] == agent) || (totalBoard[1] == agent && totalBoard [7] == agent)) || (totalBoard[4] == agent && totalBoard [7] == agent)){
			if (!(totalBoard [1] == 2 || totalBoard[4] == 2 || totalBoard[7] == 2)) {
				utility -= 2;
			}
		}
		if(((totalBoard[6] == agent && totalBoard [7] == agent) || (totalBoard[7] == agent && totalBoard [8] == agent)) || (totalBoard[6] == agent && totalBoard [8] == agent)){
			if (!(totalBoard [6] == 2 || totalBoard[7] == 2 || totalBoard[8] == 2)) {
				utility -= 2;
			}
		}
		if(((totalBoard[2] == agent && totalBoard [5] == agent) || (totalBoard[2] == agent && totalBoard [8] == agent)) || (totalBoard[5] == agent && totalBoard [8] == agent)){
			if (!(totalBoard [2] == 2 || totalBoard[5] == 2 || totalBoard[8] == 2)) {
				utility -= 2;
			}
		}
		if(((totalBoard[2] == agent && totalBoard [4] == agent) || (totalBoard[2] == agent && totalBoard [6] == agent)) || (totalBoard[4] == agent && totalBoard [6] == agent)){
			if (!(totalBoard [2] == 2 || totalBoard[4] == 2 || totalBoard[6] == 2)) {
				utility -= 2;
			}
		}

		return utility;

	}

	public bool CheckForWin (int[,] board, int boardNum, int agentNum){

		//1 = X
		//2 = O

		int theInt = agentNum;

		int[] s = new int[9];

		for (int i = 0; i < 9; i++) {
			s [i] = board [boardNum, i];
		}


		if (s [0] == theInt && (s [1] == theInt && s [2] == theInt)) {
			return true;
		} else if (s [3] == theInt && (s [4] == theInt && s [5] == theInt)) {
			return true;
		} else if (s [6] == theInt && (s [7] == theInt && s [8] == theInt)) {
			return true;
		} else if (s [0] == theInt && (s [3] == theInt && s [6] == theInt)) {
			return true;
		} else if (s [1] == theInt && (s [4] == theInt && s [7] == theInt)) {
			return true;
		} else if (s [2] == theInt && (s [5] == theInt && s [8] == theInt)) {
			return true;
		} else if (s [0] == theInt && (s [4] == theInt && s [8] == theInt)) {
			return true;
		} else if (s [2] == theInt && (s [4] == theInt && s [6] == theInt)) {
			return true;
		} else {
			return false;
		}

	}

	public bool CheckForWinNo2DArray (int[] board, int agentNum){

		int[] s = board;

		int theInt = agentNum;

		if (s [0] == theInt && (s [1] == theInt && s [2] == theInt)) {
			return true;
		} else if (s [3] == theInt && (s [4] == theInt && s [5] == theInt)) {
			return true;
		} else if (s [6] == theInt && (s [7] == theInt && s [8] == theInt)) {
			return true;
		} else if (s [0] == theInt && (s [3] == theInt && s [6] == theInt)) {
			return true;
		} else if (s [1] == theInt && (s [4] == theInt && s [7] == theInt)) {
			return true;
		} else if (s [2] == theInt && (s [5] == theInt && s [8] == theInt)) {
			return true;
		} else if (s [0] == theInt && (s [4] == theInt && s [8] == theInt)) {
			return true;
		} else if (s [2] == theInt && (s [4] == theInt && s [6] == theInt)) {
			return true;
		} else {
			return false;
		}

	}

}
