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
		Set<int[]> beforeWorld, afterTikWorld;
		beforeWorld = new HashSet<int[]>();
		beforeWorld.add(new int[] { 0, 0 });
		// Act
		game.setWorld(beforeWorld);
		game.tik();
		// Assert
		afterTikWorld = new HashSet<int[]>();
		Assert.assertEquals(true, game.getWorld().equals(afterTikWorld));
	}
}
