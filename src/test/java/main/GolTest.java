package main;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GolTest {
  @Test
  public void LessNeighboursThenTwo() {
	  //Arrange
	  GameOfLife game = new GameOfLife();
	  Map<Integer,Integer> BeforeWorld, AfterTikWorld;
	  BeforeWorld = new HashMap<Integer, Integer>();
	  BeforeWorld.put(0, 0);
	  //Act
	  game.setWord(BeforeWorld);
	  game.tik();
	  //Assert
	  AfterTikWorld = new HashMap<Integer, Integer>();
	  AfterTikWorld=game.getWord();
	  Assert.assertEquals(true, BeforeWorld.equals(AfterTikWorld));
  }
}
