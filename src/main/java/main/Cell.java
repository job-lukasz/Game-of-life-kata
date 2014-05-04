package main;

public class Cell {
	private int x, y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Cell))
			return false;
		Cell otherCell = (Cell) other;
		return otherCell.x == x && otherCell.y == y;
	}

	public int hashCode() {
		int hash = 17;
		hash = hash * 31 + x;
		hash = hash * 31 + y;
		return hash;
	}
};