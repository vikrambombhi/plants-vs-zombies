package model;

import java.util.Stack;

public class CurrentStateStack {
//	private static Stack<LevelInfo> pastLevel;
//	private static Stack<LevelInfo> futureLevel;
	private static Stack<PlayerInfo> pastMove;
	private static Stack<PlayerInfo> futureMove;
	
	public void saveCurrentState(PlayerInfo currentPlayerInfo) throws CloneNotSupportedException {
		pastMove.push((PlayerInfo) currentPlayerInfo.clone());
		futureMove.clear();
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
