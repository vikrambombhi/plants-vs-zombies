import java.util.LinkedList;

public class Tile {
	private Plant plant;
	private LinkedList<Zombies> zombies;
	private LinkedList<Projectile> projectiles;

	//All tiles contain no plant initially or in other words the board is clear
	public Tile(){
		super();
		this.plant = null;
		this.zombies = new LinkedList<Zombies>(); //first zombie in list gets hit, after he dies remove first from list
		this.projectiles = new LinkedList<Projectile>();
	}

	//returns the plant that exists inside this tile
	public Plant getPlant() {
		return plant;
	}

	//sets plant inside tile to given plant
	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	//removes plant from tile by setting tile to null
	public void removePlant(){
		this.plant = null;
	}

	public void addZombie(Zombies zombie) {
		this.zombies.add(zombie);
	}

	public LinkedList<Zombies> getZombies() {
		return this.zombies;
	}

	public void removeZombies() {
		this.zombies.clear();
	}

	public void addProjectile(Projectile projectile) {
		this.projectiles.add(projectile);
	}

	public LinkedList<Projectile> getProjectiles() {
		return projectiles;
	}

	public void removeProjectiles() {
		this.projectiles.clear();
	}

	public void removeNProjectiles(int n) {
		for (int i = 0; i < n; i++) {
			this.projectiles.remove();
		}
	}

	public TurnResult turn() {
		int generatedSunPoints = 0;
		int zombiesEliminated = 0;

		if (this.plant != null) {
			if (this.plant.getType() == 'S') { // this should be changed later
				Sunflower sunflower = (Sunflower) this.plant;
				generatedSunPoints += sunflower.generateSunPoints();
			} else {
				OffensivePlant offensivePlant = (OffensivePlant) this.plant;
				Projectile projectile = offensivePlant.generateProjectile();
				if (projectile != null) projectiles.add(projectile);
			}
		}

		while (zombies.size() != 0 && projectiles.size() != 0) {
			Zombies zombie = zombies.peek();
			while (zombie.getHP() > 0 && projectiles.size() != 0) {
				Projectile projectile = projectiles.poll();
				zombie.takeDamage(projectile.getDamage());
			}

			if (zombie.getHP() == 0) {
				zombies.remove();
				zombiesEliminated++;
			}
		}

		if (this.plant != null) {
			for (Zombies zombie : zombies) {
				if (this.plant.getHP() == 0) {
					this.plant = null;
					break;
				}

				this.plant.takeDamage(zombie.getDamage());
			}
		}

		return new TurnResult(generatedSunPoints, zombiesEliminated);
	}

	// add how many zombies in toString()
	@Override
	public String toString(){
		if (plant != null && zombies.size() == 0) return " " + plant.toString();
		if (plant != null && zombies.size() > 0) return " B"; // for both
		if (plant == null && zombies.size() > 0) return " " + zombies.peek().toString();
		if (plant == null && zombies.size() == 0 && projectiles.size() > 0) return " " + projectiles.peek().toString();

		return " _";
	}
}
