public class TurnResult {
	private final int GENERATED_SUN_POINTS;
	private final int ZOMBIES_ELIMINATED;
    private final int PROJECTILES_HIT;

	public TurnResult(int generatedSunPoints, int zombiesEliminated, int projectilesHit) {
		this.GENERATED_SUN_POINTS = generatedSunPoints;
		this.ZOMBIES_ELIMINATED = zombiesEliminated;
        this.PROJECTILES_HIT = projectilesHit;
	}

    public TurnResult(int generatedSunPoints, int zombiesEliminated) {
        this(generatedSunPoints, zombiesEliminated, 0);
    }

	public int getGeneratedSunPoints() {
		return GENERATED_SUN_POINTS;
	}

	public int getZombiesEliminated() {
		return ZOMBIES_ELIMINATED;
	}

    public int getProjectilesHit() {
        return PROJECTILES_HIT;
    }
}
