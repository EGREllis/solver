package net.ellise.sudoku.view.cli;

import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.View;

import java.io.PrintStream;

public class CliView implements View {
    private static final String HEADER = "+---+---+---+\n";
    private final PrintStream output;
    private Puzzle puzzle;

    public CliView(PrintStream output) {
        this.output = output;
    }

    @Override
    public Puzzle getPuzzle() {
        return puzzle;
    }

    public void render(Puzzle puzzle) {
        this.puzzle = puzzle;
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

    @Override
    public Place getSelected() {
        return null;
    }
}
