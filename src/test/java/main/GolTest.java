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
	public void lessNeighboursThenTwoCellDie() {
		// Arrange

		beforeWorld.add(new Cell(0, 0));
		// Act
		game.setWorld(beforeWorld);
		game.tik();
		// Assert
		Assert.assertEquals(game.getWorld().equals(afterTikWorld), true);
	}

	@Test
	public void twoNeighboursCellAlive() {
		// Arrange
		beforeWorld.add(new Cell(-1, 1));
		beforeWorld.add(new Cell(0, 0));
		beforeWorld.add(new Cell(1, -1));
		// Act
		game.setWorld(beforeWorld);
		game.tik();
		// Assert
		afterTikWorld.add(new Cell(0, 0));
		Assert.assertEquals(game.getWorld().equals(afterTikWorld), true);
	}
	
	@Test
	public void threeNeighboursCellAlive() {
		// Arrange
		beforeWorld.add(new Cell(-1, -1));
		beforeWorld.add(new Cell(0, 0));
		beforeWorld.add(new Cell(1, 1));
		beforeWorld.add(new Cell(-1,1));
		// Act
		game.setWorld(beforeWorld);
		game.tik();
		// Assert
		afterTikWorld.add(new Cell(0, 0));
		afterTikWorld.add(new Cell(-1, 0));
		afterTikWorld.add(new Cell(0, 1));
		Assert.assertEquals(game.getWorld().equals(afterTikWorld), true);
	}
	
	@Test
	public void moreThenThreeNeighboursCellDie() {
		// Arrange
		beforeWorld.add(new Cell(-1, -1));
		beforeWorld.add(new Cell(0, 0));
		beforeWorld.add(new Cell(1, 1));
		beforeWorld.add(new Cell(-1,1));
		beforeWorld.add(new Cell(1,-1));
		// Act
		game.setWorld(beforeWorld);
		game.tik();
		// Assert
		afterTikWorld.add(new Cell(0,1));
		afterTikWorld.add(new Cell(0,-1));
		afterTikWorld.add(new Cell(1,0));
		afterTikWorld.add(new Cell(-1,0));
		Assert.assertEquals(game.getWorld().equals(afterTikWorld), true);
	}
	@Test
	public void threeNeighboursCellRevive() {
		// Arrange
		beforeWorld.add(new Cell(-1, -1));
		beforeWorld.add(new Cell(1, 1));
		beforeWorld.add(new Cell(1,-1));
		// Act
		game.setWorld(beforeWorld);
		game.tik();
		// Assert
		afterTikWorld.add(new Cell(0, 0));
		Assert.assertEquals(game.getWorld().equals(afterTikWorld), true);
	}
	
}
