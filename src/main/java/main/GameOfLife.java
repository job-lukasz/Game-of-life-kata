package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameOfLife {
	private Set<Cell> worldBeforeTik, worldAfterTik;
	private final int[][] neighboursPositionTable = new int[][] { { -1, 1 }, { 0, 1 }, { 1, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 },
			{ 0, -1 }, { 1, -1 } };

	public Set<Cell> getWorld() {
		return worldBeforeTik;
	}

	public void setWorld(Set<Cell> world) {
		this.worldBeforeTik = world;
	}

	public void tik() {
		worldAfterTik = new HashSet<Cell>();
		reviveCells();
		killCells();
		worldBeforeTik = worldAfterTik;
	}

	private void killCells() {
		updateCells(worldBeforeTik.iterator(), false);
	}

	private void reviveCells() {
		Set<Cell> reviveCandidates = findCandidatesToRevive();
		updateCells(reviveCandidates.iterator(), true);
	}

	private Set<Cell> findCandidatesToRevive() {
		Iterator<Cell> worldIterator = worldBeforeTik.iterator();
		Set<Cell> reviveCandidates = new HashSet<Cell>();
		while (worldIterator.hasNext()) {
			Cell cell = worldIterator.next();
			for (int i = 0; i < 8; i++) {
				reviveCandidates.add(createNeighbourCell(cell, i));
			}
		}
		return reviveCandidates;
	}

	private void updateCells(Iterator<Cell> worldIterator, boolean isReviving) {
		while (worldIterator.hasNext()) {
			Cell cell = worldIterator.next();
			int neighbours = countNeighbours(cell);
			if ((neighbours == 2 && !isReviving) || neighbours == 3) {
				worldAfterTik.add(cell);
			}
		}
	}

	private int countNeighbours(Cell cell) {
		int neighbours = 0;
		for (int i = 0; i < 8; i++) {
			if (worldBeforeTik.contains(createNeighbourCell(cell, i))) {
				neighbours++;
			}
		}
		return neighbours;
	}

	private Cell createNeighbourCell(Cell cell, int neighbourPosition) {
		return new Cell(cell.getX() + neighboursPositionTable[neighbourPosition][0], cell.getY()
				+ neighboursPositionTable[neighbourPosition][1]);
	}
}
