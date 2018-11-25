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

}
