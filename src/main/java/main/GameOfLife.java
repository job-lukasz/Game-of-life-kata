package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameOfLife {
	private Set<Cell> world;
	private final int[][] neighboursTable= new int[][]{{-1,1},{0,1},{1,1},
														  {-1,0},	   {1,0},
														  {-1,-1},{0,-1},{1,-1}
	};
	public Set<Cell> getWorld() {
		return world;
	}
	public void setWorld(Set<Cell> world) {
		this.world = world;
	}

	public void tik(){
		Set<Cell> newWorld = new HashSet<Cell>();
		Iterator<Cell> worldIterator = world.iterator();
		while(worldIterator.hasNext()){
			int neighbours = 0;
			Cell cell = worldIterator.next();
			for(int i=0;i<8;i++){
				if(world.contains(new Cell(cell.getX()+neighboursTable[i][0],cell.getY()+neighboursTable[i][1]))){
					neighbours++;
				}
			}
			if(neighbours==2||neighbours==3){
				newWorld.add(cell);
			}
		}
		world = newWorld;
	}
}
