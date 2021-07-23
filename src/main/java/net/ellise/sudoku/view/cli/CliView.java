package net.ellise.sudoku.view.cli;

import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;

public class CliView {
    private static final String HEADER = "+---+---+---+\n";

    public String render(Puzzle puzzle) {
        StringBuilder result = new StringBuilder();
        for (int row : Puzzle.HEIGHT) {
            if (row % 3 == 1) {
                result.append(HEADER);
            }
            for (int col : Puzzle.WIDTH) {
                Place place = new Place(col, row);

                if (col % 3 == 1) {
                    result.append("|");
                }
                int value = puzzle.getCellAt(place);
                result.append(value == 0 ? " " : value);
            }
            result.append("|\n");
        }
        result.append(HEADER);
        return result.toString();
    }

    private String header() {
        return "+---+---+---+\n";
    }
}
