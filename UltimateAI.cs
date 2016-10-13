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

		State current = new State (smallBoards, totalBoard, nextMove);
		//Calls agent 2, which is the maximizer (AI)
		List<Object> allPossible = current.getAllMoves (current, 2);
		List<int> moveUtils = new List<int>();

		//In essence, this is the top maximizing node. So, when value is called, go MIN, MAX, MIN
		int maxPossible = -10000;
		for (int i = 0; i < allPossible.Count (); i++) {
			//Get depth two
			moveUtils.Add (allPossible [i].value (current, 4, 0, 1));
			maxPossible = max(maxPossible, moveUtils.get(i));
		}


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
			return maxValue (State current, maxDepth, currentDepth, 2);
		}

		//if next is min, return min-value
		if (agent == 1) {
			return minValue (State current, maxDepth, currentDepth, 1);
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
		for(element successor in current.getAllMoves(current, agentNum)){
			v = Mathf.Min(v, value(successor, maxDepth, currentDepth + 1, nextAgent));
		}//each successor of state
		return v;
	}

}

class State : MonoBehaviour {

	int[,] smallBoards;
	int[] totalBoard;
	int nextMove;

	public State(int[,] smallBoards, int[] totalBoard, int nextMove){
		this.smallBoards = smallBoards;
		this.totalBoard = totalBoard;
		this.nextMove = nextMove;
	}
	
	
	//Agent: 1 = min, 2 = max
	public List<Object> getAllMoves(State current, int agent){
		int board = current.nextMove;
		List<Object> allPossibleMoves = new List<Object>();
		if(board == -1){
			//TODO
		} else {
			for(int i = 0; i < 9; i++){
				if(smallBoards[board, i] == 0){
					//Open space = possible move!
					int[,] tempSmall = smallBoards;
					tempSmall[board, i] = agent;
					int[] tempTotal = totalBoard;
					if(CheckForWin(tempSmall, board)){
						tempTotal[board] = agent;
					}
					int tempMove = i;
					State possible = new State(tempSmall, tempTotal, tempMove);
					allPossibleMoves.Add(possible);
				}
			}
		}

		return allPossibleMoves;

	}

	public int getValue(){
		//TODO Get utility score of this state
	}

	bool CheckForWin (int[,] board, int boardNum){

		//1 = X
		//2 = O

		int theInt = 2;//TODO What about X?

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
