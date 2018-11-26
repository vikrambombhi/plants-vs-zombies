package model;

import java.util.Stack;

public class CurrentStateStack {
//	private static Stack<LevelInfo> pastLevel;
//	private static Stack<LevelInfo> futureLevel;
	private static Stack<Stats> pastMove;
	private static Stack<Stats> futureMove;
	
	public CurrentStateStack() {
		pastMove = new Stack<Stats>();
		futureMove = new Stack<Stats>();
	}
	
	public void saveCurrentState(Stats currentStats) throws CloneNotSupportedException {
		pastMove.push((Stats) currentStats.clone());
		futureMove.clear();
	}
	
	public Stats undoMove() {
		Stats tempPlayer = null; // Make a temp Stats to store info from stack
		
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
	
	public Stats redoMove() {
		Stats tempMove = null; // Make a temp Stats to store info from stack
		
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
