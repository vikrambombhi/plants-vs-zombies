import java.util.LinkedList;

public class Tile {
	private Plant plant;
	private LinkedList<Zombie> zombies;

	//All tiles contain no plant initially or in other words the board is clear
	public Tile(){
		super();
		this.plant = null;
		this.zombies = new List<>(); //first zombie in list gets hit, after he dies remove first from list
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

	public void addZombie(Zombie zombie) {
		zombies.add(zombie);
	}

	// add how many zombies in toString()
	@Override
	public String toString(){
		if(plant == null){
			return "-";
		}
		else{
			return plant.toString();
		}
	}
}
