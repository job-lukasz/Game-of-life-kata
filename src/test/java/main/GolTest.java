package main;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GolTest {
	@Test
	public void LessNeighboursThenTwo() {
		// Arrange
		GameOfLife game = new GameOfLife();
		Set<Cell> beforeWorld, afterTikWorld;
		beforeWorld = new HashSet<Cell>();
		beforeWorld.add(new Cell(0, 0));
		// Act
		game.setWorld(beforeWorld);
		game.tik();
		// Assert
		afterTikWorld = new HashSet<Cell>();
		Assert.assertEquals(game.getWorld().equals(afterTikWorld),true);
	}
	@Test
	public void TwoNeighboursCellAlive() {
		// Arrange
		GameOfLife game = new GameOfLife();
		Set<Cell> beforeWorld, afterTikWorld;
		beforeWorld = new HashSet<Cell>();
		beforeWorld.add(new Cell(-1, 0));
		beforeWorld.add(new Cell(0, 0));
		beforeWorld.add(new Cell(1, 0));
		// Act
		game.setWorld(beforeWorld);
		game.tik();
		// Assert
		afterTikWorld = new HashSet<Cell>();
		afterTikWorld.add(new Cell(0, 0));
		Assert.assertEquals(game.getWorld().equals(afterTikWorld), true);
	}
}
