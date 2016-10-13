using UnityEngine;
using System.Collections;

public class UltimateAI : MonoBehaviour {

	public UltimateAI(){
		//Nothing to init rn
		return;
	}
		

	//Needs to return a button GameObject TODO TODO TODO TODO
	//nextMove is the board where you need to move next. -1 if anywhere (zero-based!)
	public GameObject move(int[,] smallBoards, int[] totalBoard, int nextMove){
		//TODO Take care of anywhere and the time that would take on depth 2...

		State current = new State (smallBoards, totalBoard, nextMove, 2);
		//Calls agent 2, which is the maximizer (AI)
		List<State> allPossible = current.getAllMoves (current, 2);
		List<int> moveUtils = new List<int>();

		//In essence, this is the top maximizing node. So, when value is called, go MIN, MAX, MIN
		int maxPossible = -10000;
		for (int i = 0; i < allPossible.Count (); i++) {
			//Get depth two
			moveUtils.Add (allPossible [i].value (current, 4, 0, 1));
			maxPossible = Mathf.Max(maxPossible, moveUtils.get(i));
		}
		
		State bestMove = allPossible.get(moveUtils.indexOf(maxPossible))
		//Determine which button needs to be pressed... and return. 
		//Wow, that means I need to reference every single button from this. Well, there goes my weekend.
		//TODO
		return new GameObject();
	}


	//1 = min, 2 = max
	int value (State current, int maxDepth, int currentDepth, int agent){
		//if state at depth 2 or sure win, return utility
		if (currentDepth >= maxDepth) {
			return utility;//TODO
		}

		//if next is max, return max-value
		if (agent == 2) {
			return maxValue (current, maxDepth, currentDepth, 2);
		}

		//if next is min, return min-value
		if (agent == 1) {
			return minValue (current, maxDepth, currentDepth, 1);
		}
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
		foreach(element successor in current.getAllMoves(current, agentNum)){
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
		foreach(element successor in current.getAllMoves(current, agentNum)){
			v = Mathf.Min(v, value(successor, maxDepth, currentDepth + 1, nextAgent));
		}//each successor of state
		return v;
	}

}

class State : MonoBehaviour {

	int[,] smallBoards;
	int[] totalBoard;
	int nextMove;
	int agentNum;

	public State(int[,] smallBoards, int[] totalBoard, int nextMove, int agentNum){
		this.smallBoards = smallBoards;
		this.totalBoard = totalBoard;
		this.nextMove = nextMove;
		this.agentNum = agentNum;
	}
	
	
	//Agent: 1 = min, 2 = max
	public List<State> getAllMoves(State current, int agent){
		int board = current.nextMove;
		List<State> allPossibleMoves = new List<State>();
		if(board == -1){
			//Return every open square in squares not already won.
			for(int i = 0; i < 9; i++){
				if(totalBoard[i] != 1 && totalBoard[i] != 2){
					for(int x = 0; x < 9; x++){
						if(smallBoard[i,x] == 0){
							int[,] tempSmall = smallBoards;
							tempSmall[i, x] = agent;
							int[] tempTotal = totalBoard;
							if(CheckForWin(tempSmall, i, agent)){//Instead of board being passed (-1), we pass the board number 
									tempTotal[i] = agent;
							}
							int tempMove = x;
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
				if(smallBoards[board, i] == 0){
					//Open space = possible move!
					int[,] tempSmall = smallBoards;
					tempSmall[board, i] = agent;
					int[] tempTotal = totalBoard;
					if(CheckForWin(tempSmall, board, agent)){
						tempTotal[board] = agent;
					}
					int tempMove = i;
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
		//TODO Get utility score of this state
		int utility = 0;
		
		return utility;		
	}

	bool CheckForWin (int[,] board, int boardNum, int agentNum){

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

}
