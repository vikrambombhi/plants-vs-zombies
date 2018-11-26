package model;

import java.io.Serializable;
import java.util.ArrayDeque;

public class Tile implements Serializable {
	private Plants plant;
	private ArrayDeque<Zombies> zombies;
	private ArrayDeque<Projectile> projectiles;

	// All tiles contain no plant initially or in other words the board is clear
	public Tile() {
		super();
		this.plant = null;
		this.zombies = new ArrayDeque<Zombies>(); // first zombie in list gets hit, after he dies remove first from list
		this.projectiles = new ArrayDeque<Projectile>();
	}

	// returns the plant that exists inside this tile
	public Plants getPlant() {
		return plant;
	}

	// sets plant inside tile to given plant
	public void setPlant(Plants plant) {
		this.plant = plant;
	}

	// removes plant from tile by setting tile to null
	public void removePlant() {
		this.plant = null;
	}

	public void addZombie(Zombies zombie) {
		if (this.plant == null) {
			this.zombies.add(zombie);
		}
	}

	public ArrayDeque<Zombies> getZombies() {
		return this.zombies;
	}

	public void removeZombies() {
		this.zombies.clear();
	}

	public void addProjectile(Projectile projectile) {
		this.projectiles.add(projectile);
	}

	public ArrayDeque<Projectile> getProjectiles() {
		return projectiles;
	}

	public void removeProjectiles() {
		this.projectiles.clear();
	}

	public void removeFirstProjectile() {
		this.projectiles.remove();
	}

	public void turn(Zombies zombie) {
		for (Projectile projectile : projectiles) {
			if (zombie.getHP() == 0) break;
			zombie.takeDamage(projectile.getDamage());
			projectiles.remove(projectile);
		}
	}

	/*
	 * Is called by Board's turn() method. If the tile has a plant and it's an offensive one, then it tries to trigger its ability if it's off cooldown.
	 * If there are zombies on the tile as well as projectiles, zombies are hit by projectiles.
	 */
	public void turn() {
		Stats stats = Stats.getStats();
		if (this.plant != null && (this.plant.getType() != PlantTypes.SUNFLOWER.getType())) {
			OffensivePlant offensivePlant = (OffensivePlant) this.plant;
			Projectile projectile = offensivePlant.generateProjectile();
			if (projectile != null) projectiles.add(projectile);
		} else if (!zombies.isEmpty()) {
			for (Projectile p : projectiles) {
				if (!zombies.isEmpty()) {
					Zombies zombie = zombies.peek();
					zombie.takeDamage(p.getDamage());
					projectiles.pop();
					if (zombie.getHP() == 0) {
						zombies.pop();
						stats.zombieEliminated();
					}
				}
			}
		}
	}

	// add how many zombies in toString()
	@Override
	public String toString() {
		if (plant != null && zombies.size() == 0)
			return "" + plant.getType();
		if (plant != null && zombies.size() > 0)
			return " B"; // for both
		if (plant == null && zombies.size() > 0)
			return " " + zombies.peek().getType();
		if (plant == null && zombies.size() == 0 && projectiles.size() > 0)
			return " " + projectiles.peek().toString();

		return "";
	}
}
