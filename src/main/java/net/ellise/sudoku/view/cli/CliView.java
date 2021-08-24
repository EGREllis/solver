package net.ellise.sudoku.view.cli;

import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;

import java.io.PrintStream;

public class CliView {
    private static final String HEADER = "+---+---+---+\n";
    private final PrintStream output;

    public CliView(PrintStream output) {
        this.output = output;
    }

    public void render(Puzzle puzzle) {
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
        output.println(result);
        output.flush();
    }
}
