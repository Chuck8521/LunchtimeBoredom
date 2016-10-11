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
		ArrayList allPossible = current.getAllMoves ();
		ArrayList moveUtils = new ArrayList();

		for (int i = 0; i < allPossible.Count (); i++) {
			moveUtils.Add (allPossible [i].value ());
		}


		return new GameObject();
	}



	int depth = 0;
	//0 = max, 1 = min
	int agent = 0;

	int value (){
		//if state at depth 2 or sure win, return utility
		if (depth == 2) {
			return utility;//TODO
		}

		//if next is max, return max-value
		if (agent == 0) {
			return maxValue (State);
		}

		//if next is min, return min-value
		if (agent == 0) {
			return minValue (State);
		}
	}


	int maxValue (State){
		int v = -10000;
		for(){
			v = Mathf.Max(v, value(successor));//WARNING: Mathf, not Math. Does it matter?
		}//each successor of state
		return v;
	}

	int minValue (State){
		int v = 10000;
		for(){
			v = Mathf.Min(v, value(successor));
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

	public ArrayList getAllMoves(State current){
		int board = current.nextMove;
		ArrayList allPossibleMoves = new ArrayList();
		if(board == -1){
			//TODO
		} else {
			for(int i = 0; i < 9; i++){
				if(smallBoards[board, i] == 0){
					//Open space = possible move!
					int[,] tempSmall = smallBoards;
					tempSmall[board, i] = 2;//TODO What about when I'm modeling the minimizer?
					int[] tempTotal = totalBoard;
					if(CheckForWin(tempSmall, board)){
						tempTotal[board] = 2;//TODO Ahhhhhh same as above
					}
					int tempMove = nextMove;
					tempMove = i;
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
