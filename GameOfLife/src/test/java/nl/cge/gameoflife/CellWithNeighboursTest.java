package nl.cge.gameoflife;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellWithNeighboursTest {

    @CsvSource(value = {
            "X ? X X O X X X X, false",
            "X ? O X O O X X X, true ",
            "? ? ? ? O O O O O, false",
            "X X O X X O X X O, true "
    })
    @ParameterizedTest
    void test(String data, boolean expAlive) {
        CellWithNeighbours cellWithNeighbours = new CellWithNeighbours(data);
        cellWithNeighbours.printCellsAndOutcome();
        assertEquals(expAlive, cellWithNeighbours.isAlive());
    }

}