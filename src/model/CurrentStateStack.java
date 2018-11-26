package model;

import java.util.Stack;

public class CurrentStateStack {
//	private static Stack<LevelInfo> pastLevel;
//	private static Stack<LevelInfo> futureLevel;
	private static Stack<PlayerInfo> pastMove;
	private static Stack<PlayerInfo> futureMove;
	
	public CurrentStateStack() {
		pastMove = new Stack<PlayerInfo>();
		futureMove = new Stack<PlayerInfo>();
	}
	
	public void saveCurrentState(PlayerInfo currentPlayerInfo) throws CloneNotSupportedException {
		pastMove.push((PlayerInfo) currentPlayerInfo.clone());
		futureMove.clear();
	}
	
	public PlayerInfo undoMove() {
		PlayerInfo tempPlayer = null; // Make a temp playerinfo to store info from stack
		
		if(!pastMove.isEmpty()){
			tempPlayer = pastMove.pop();
			//printGrid(templist);
			futureMove.push(tempPlayer);
		}
		return tempPlayer;
	}
	
	public boolean undoChecker() {
		boolean checker = !pastMove.isEmpty();
		return checker;
	}
	
	public PlayerInfo redoMove() {
		PlayerInfo tempMove = null; // Make a temp playerinfo to store info from stack
		
		if(!futureMove.isEmpty()) {
			tempMove = futureMove.pop();
			pastMove.push(tempMove);
		}
		return tempMove;
	}
	
	public boolean redoChecker() {
		boolean checker = !futureMove.isEmpty();
		return checker;
	}
}
