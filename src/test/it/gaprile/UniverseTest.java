package it.gaprile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import it.gaprile.Cell;
import it.gaprile.Universe;


public class UniverseTest {

	@Test
	public void expectstToFindNextGenerationBlockPattern() {
		List<Cell> seeds = new LinkedList<>();
		seeds.add(new Cell(1, 1));
		seeds.add(new Cell(1, 2));
		seeds.add(new Cell(2, 1));
		seeds.add(new Cell(2, 2));
		List<Cell> expectedAliveCells = new LinkedList<>();
		expectedAliveCells.add(new Cell(1, 1));
		expectedAliveCells.add(new Cell(1, 2));
		expectedAliveCells.add(new Cell(2, 1));
		expectedAliveCells.add(new Cell(2, 2));
		Universe universe = new Universe(seeds);

		List<Cell> nextGeneration = universe.nextGeneration();

		assertEquals(expectedAliveCells, nextGeneration);
	}

	@Test
	public void expectsNotToFindCellsDyingInNextGeneration() {
		List<Cell> seeds = new LinkedList<>();
		seeds.add(new Cell(1, 1));
		seeds.add(new Cell(1, 2));
		seeds.add(new Cell(1, 3));
		List<Cell> expectedAliveCells = new LinkedList<>();
		expectedAliveCells.add(new Cell(1, 1));
		expectedAliveCells.add(new Cell(2, 4));
		expectedAliveCells.add(new Cell(2, 3));
		Universe universe = new Universe(seeds);

		List<Cell> nextGeneration = universe.nextGeneration();

		assertNotEquals(expectedAliveCells, nextGeneration);
	}

	@Test
	public void expectstToFindNextGenerationBoatPattern() {
		List<Cell> seeds = new LinkedList<>();
		seeds.add(new Cell(0, 1));
		seeds.add(new Cell(1, 0));
		seeds.add(new Cell(2, 1));
		seeds.add(new Cell(0, 2));
		seeds.add(new Cell(1, 2));
		List<Cell> expectedAliveCells = new LinkedList<>();
		expectedAliveCells.add(new Cell(0, 1));
		expectedAliveCells.add(new Cell(1, 0));
		expectedAliveCells.add(new Cell(2, 1));
		expectedAliveCells.add(new Cell(0, 2));
		expectedAliveCells.add(new Cell(1, 2));
		Universe universe = new Universe(seeds);

		List<Cell> nextGeneration = universe.nextGeneration();

		assertEquals(expectedAliveCells, nextGeneration);
	}

	@Test
	public void expectstToFindNextGenerationBlinkerPattern() {
		List<Cell> seeds = new LinkedList<>();
		seeds.add(new Cell(1, 1));
		seeds.add(new Cell(1, 0));
		seeds.add(new Cell(1, 2));
		List<Cell> expectedAliveCells = new LinkedList<>();
		expectedAliveCells.add(new Cell(1, 1));
		expectedAliveCells.add(new Cell(0, 1));
		expectedAliveCells.add(new Cell(2, 1));
		Universe universe = new Universe(seeds);

		List<Cell> nextGeneration = universe.nextGeneration();

		assertEquals(expectedAliveCells, nextGeneration);
	}

	@Test
	public void expectsToFindNextGeneration() {
		List<Cell> seeds = new LinkedList<>();
		seeds.add(new Cell(1, 1));
		seeds.add(new Cell(1, 2));
		seeds.add(new Cell(1, 3));
		seeds.add(new Cell(2, 2));
		seeds.add(new Cell(2, 3));
		seeds.add(new Cell(2, 4));
		List<Cell> expectedAliveCells = new LinkedList<>();
		expectedAliveCells.add(new Cell(1, 1));
		expectedAliveCells.add(new Cell(2, 4));
		expectedAliveCells.add(new Cell(0, 2));
		expectedAliveCells.add(new Cell(2, 1));
		expectedAliveCells.add(new Cell(1, 4));
		expectedAliveCells.add(new Cell(3, 3));
		Universe universe = new Universe(seeds);

		List<Cell> nextGeneration = universe.nextGeneration();

		assertEquals(expectedAliveCells, nextGeneration);
	}

	@Test
	public void aSingleCellShouldHaveZeroNeighbors() {
		List<Cell> seeds = new LinkedList<>();
		seeds.add(new Cell(0, 0));
		Universe universe = new Universe(seeds);

		List<Cell> nextGeneration = universe.nextGeneration();

		assertEquals(0, nextGeneration.size());
	}
}
