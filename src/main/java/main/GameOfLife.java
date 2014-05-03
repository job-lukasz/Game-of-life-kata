package main;

import java.util.Set;

public class GameOfLife {
	private Set<int []> world;

	public Set<int[]> getWorld() {
		return world;
	}
	public void setWorld(Set<int []> world) {
		this.world = world;
	}

	public void tik(){
		world.clear();
	}
}
