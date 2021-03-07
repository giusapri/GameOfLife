package it.gaprile;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import it.gaprile.Cell;
import it.gaprile.Universe;


public class GameOfLifeTest {

	List<Cell> nextGeneration = null;


	@Test
	public void aSingleCellShouldDieInNextTick() {
		List<Cell> seeds = new LinkedList<>();
		Cell firstCell = new Cell(0, 0);
		seeds.add(firstCell);
		Universe universe = new Universe(seeds);
		nextGeneration = universe.nextGeneration();

		assertFalse(this.isAlive(firstCell));
	}

	@Test
	public void aCellWithOnlyOneNeighborShouldDieInNextTick() {
		List<Cell> seeds = new LinkedList<>();
		Cell firstCell = new Cell(0, 0);
		Cell secondCell = new Cell(0, 1);
		seeds.add(firstCell);
		seeds.add(secondCell);
		Universe universe = new Universe(seeds);
		nextGeneration = universe.nextGeneration();

		assertFalse(this.isAlive(firstCell));
		assertFalse(this.isAlive(secondCell));
	}

	@Test
	public void cellWithTwoNeighborsShouldLiveInNextTick() {
		List<Cell> seeds = new LinkedList<>();
		Cell middleCell = new Cell(1, 0);
		Cell upperCell = new Cell(0, 0);
		Cell bottomCell = new Cell(2, 0);
		seeds.add(middleCell);
		seeds.add(upperCell);
		seeds.add(bottomCell);

		Universe universe = new Universe(seeds);
		nextGeneration = universe.nextGeneration();

		assertTrue(this.isAlive(middleCell));
	}

	@Test
	public void cellWithThreeNeighborsShouldLiveInNextTick() {
		List<Cell> seeds = new LinkedList<>();
		Cell middleCell = new Cell(1, 0);
		Cell upperCell = new Cell(0, 0);
		Cell bottomCell = new Cell(2, 0);
		Cell rightCell = new Cell(1, 1);
		seeds.add(middleCell);
		seeds.add(upperCell);
		seeds.add(bottomCell);
		seeds.add(rightCell);

		Universe universe = new Universe(seeds);
		nextGeneration = universe.nextGeneration();

		assertTrue(this.isAlive(middleCell));
	}

	@Test
	public void cellWithMoreThanThreeNeighborsShouldDieInNextTick() {
		List<Cell> seeds = new LinkedList<>();
		Cell middleCell = new Cell(1, 1);
		Cell upperCell = new Cell(0, 1);
		Cell bottomCell = new Cell(2, 1);
		Cell rightCell = new Cell(1, 2);
		Cell leftCell = new Cell(1, 0);
		seeds.add(middleCell);
		seeds.add(upperCell);
		seeds.add(bottomCell);
		seeds.add(rightCell);
		seeds.add(leftCell);

		Universe universe = new Universe(seeds);
		nextGeneration = universe.nextGeneration();

		assertFalse(this.isAlive(middleCell));
	}

	@Test
	public void aDeadCellWithThreeNeighborsShouldBeRebornInNextTick() {
		List<Cell> seeds = new LinkedList<>();
		Cell middleCell = new Cell(0, 0);
		Cell upperCell = new Cell(0, 1);
		Cell rightCell = new Cell(1, 0);
		Cell bottomCell = new Cell(0, -1);

		seeds.add(middleCell);
		seeds.add(upperCell);
		seeds.add(bottomCell);
		seeds.add(rightCell);

		Universe universe = new Universe(seeds);
		nextGeneration = universe.nextGeneration();

		assertTrue(this.isAlive(middleCell));
	}

	public boolean isAlive(Cell cell) {
		return this.nextGeneration.contains(cell);
	}
}
