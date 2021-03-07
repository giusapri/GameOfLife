package it.gaprile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class CellTest {
	@Test
	public void expectsNeighbours() {
		Cell cell = new Cell(1, 1);
		List<Cell> expectedNeighbours = new LinkedList<>();
		expectedNeighbours.add(new Cell(0, 0));
		expectedNeighbours.add(new Cell(0, 1));
		expectedNeighbours.add(new Cell(0, 2));
		expectedNeighbours.add(new Cell(1, 0));
		expectedNeighbours.add(new Cell(1, 2));
		expectedNeighbours.add(new Cell(2, 0));
		expectedNeighbours.add(new Cell(2, 1));
		expectedNeighbours.add(new Cell(2, 2));

		List<Cell> neighbours = cell.neighbours();

		assertEquals(expectedNeighbours, neighbours);
	}

	@Test
	public void expectsTwoCellsEqualWithSameCoordinates() {
		Cell cell = new Cell(1, 1);
		Cell anotherCell = new Cell(1, 1);

		assertTrue(cell.equals(anotherCell));
	}

	@Test
	public void expectsTwoCellsNotEqualWithDifferentCoordinates() {
		Cell cell = new Cell(1, 1);
		Cell anotherCell = new Cell(1, 2);

		assertFalse(cell.equals(anotherCell));
	}
}
