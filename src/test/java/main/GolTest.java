package main;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GolTest {
	GameOfLife game;
	Set<Cell> beforeWorld, afterTikWorld;

	@BeforeMethod
	public void initTests() {
		game = new GameOfLife();
		beforeWorld = new HashSet<Cell>();
		afterTikWorld = new HashSet<Cell>();
	}

	@Test
	public void LessNeighboursThenTwoCellDie() {
		// Arrange

		beforeWorld.add(new Cell(0, 0));
		// Act
		game.setWorld(beforeWorld);
		game.tik();
		// Assert
		Assert.assertEquals(game.getWorld().equals(afterTikWorld), true);
	}

	@Test
	public void TwoNeighboursCellAlive() {
		// Arrange
		beforeWorld.add(new Cell(-1, 0));
		beforeWorld.add(new Cell(0, 0));
		beforeWorld.add(new Cell(1, 0));
		// Act
		game.setWorld(beforeWorld);
		game.tik();
		// Assert
		afterTikWorld.add(new Cell(0, 0));
		Assert.assertEquals(game.getWorld().equals(afterTikWorld), true);
	}
}
