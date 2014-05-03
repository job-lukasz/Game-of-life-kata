package main;

import java.util.Map;

public class GameOfLife {
	private Map<Integer,Integer> world;

	public Map<Integer,Integer> getWord() {
		return world;
	}

	public void setWord(Map<Integer,Integer> world) {
		this.world = world;
	}
	
	public void tik(){
		world.clear();
	}
}
