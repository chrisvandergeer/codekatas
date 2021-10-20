package nl.cge.gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CellWithNeighbours {

    private static final int FIFTH_CELL = 4;

    private final List<Cell> cells;

    public CellWithNeighbours(String cellWithNeighbours) {
        cells = Arrays.stream(cellWithNeighbours.split(" "))
                .map(Cell::new)
                .collect(Collectors.toList());
    }

    public void printCellsAndOutcome() {
        System.out.println("-----------------");
        IntStream.range(1, 4)
                .forEach(rowNr -> System.out.println(getRowAsString(rowNr)));
        System.out.printf("----- %s -----%n", isAlive() ? "alive" : "dead ");
    }

    private String getRowAsString(int rownr) {
        int skip = (rownr - 1) * 3;
        return cells.stream().skip(skip).limit(3).map(Cell::getStatus).collect(Collectors.joining(" "));
        // 1 == 0  1 - 1 = 0, 0 * 3 = 0
        // 2 == 3  2 - 1 = 1, 1 * 3 = 3
        // 3 == 6  3 - 1 = 2, 2 * 3 = 6
    }

    private String joinAsString(Stream<Cell> cellStream) {
        return cellStream.map(Cell::getStatus).collect(Collectors.joining(" "));
    }

    public boolean isAlive() {
        List<Cell> cellWithoutSubject = new ArrayList<>(cells);
        Cell subjectCell = cellWithoutSubject.remove(FIFTH_CELL);
        long livingNeighbours = cellWithoutSubject.stream().filter(Cell::isAlive).count();
        if (subjectCell.isAlive()) {
            return livingNeighbours > 1L && livingNeighbours < 4L;
        } else if (subjectCell.isDead()) {
            return livingNeighbours == 3;
        }
        return false;
    }
}
