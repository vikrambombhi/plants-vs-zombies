public class TurnResult {
	private final int generatedSunPoints;
	private final int zombiesEliminated;
    private final int projectilesHit;

	public TurnResult(int generatedSunPoints, int zombiesEliminated, int projectilesHit) {
		this.generatedSunPoints = generatedSunPoints;
		this.zombiesEliminated = zombiesEliminated;
        this.projectilesHit = projectilesHit;
	}

    public TurnResult(int generatedSunPoints, int zombiesEliminated) {
        this(generatedSunPoints, zombiesEliminated, 0);
    }

	public int getGeneratedSunPoints() {
		return generatedSunPoints;
	}

	public int getZombiesEliminated() {
		return zombiesEliminated;
	}

    public int getProjectilesHit() {
        return projectilesHit;
    }
}