package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameOfLife {
	private Set<Cell> worldBeforeTik, worldAfterTik;
	private final int[][] neighboursTable = new int[][] { { -1, 1 }, { 0, 1 }, { 1, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { 0, -1 },
			{ 1, -1 } };

	public Set<Cell> getWorld() {
		return worldBeforeTik;
	}

	public void setWorld(Set<Cell> world) {
		this.worldBeforeTik = world;
	}

	public void tik() {
		worldAfterTik = new HashSet<Cell>();
		killCells();
		worldBeforeTik = worldAfterTik;
	}

	private void killCells() {
		Iterator<Cell> worldIterator = worldBeforeTik.iterator();
		while (worldIterator.hasNext()) {
			Cell cell = worldIterator.next();
			int neighbours = countNeighbours(cell);
			if (neighbours == 2 || neighbours == 3) {
				worldAfterTik.add(cell);
			}
		}
	}

	private int countNeighbours(Cell cell) {
		int neighbours = 0;
		for (int i = 0; i < 8; i++) {
			if (worldBeforeTik.contains(new Cell(cell.getX() + neighboursTable[i][0], cell.getY() + neighboursTable[i][1]))) {
				neighbours++;
			}
		}
		return neighbours;
	}
}
