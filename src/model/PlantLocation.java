package model;
public class PlantLocation {
	private int row, col;

	public PlantLocation(int newRow, int newCol) {
		row = newRow;
		col = newCol;
	}

	// sets row and col to given location
	public void setLocation(PlantLocation location) {
		row = location.getRow();
		col = location.getCol();
	}

	// returns row
	public int getRow() {
		return row;
	}

	// returns col
	public int getCol() {
		return col;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!PlantLocation.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		PlantLocation plantLocation = (PlantLocation) obj;
		return (plantLocation.getRow() == this.row && plantLocation.getCol() == this.col);
	}
}
