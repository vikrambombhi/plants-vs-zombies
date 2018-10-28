public class TurnResult {
	private final int generatedSunPoints;
	private final int zombiesEliminated;

	public TurnResult(int generatedSunPoints, int zombiesEliminated) {
		this.generatedSunPoints = generatedSunPoints;
		this.zombiesEliminated = zombiesEliminated;
	}

	public int getGeneratedSunPoints() {
		return generatedSunPoints;
	}

	public int getZombiesEliminated() {
		return zombiesEliminated;
	}
}