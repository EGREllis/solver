package net.ellise.sudoku.controller.command;

import net.ellise.sudoku.model.Command;
import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.View;

public class DigitCommand implements Command {
    private final View view;
    private final int value;

    public DigitCommand(View view, int value) {
        this.view = view;
        this.value = value;
    }

    @Override
    public void execute() {
        Place selected = view.getSelected();
        if (selected != null) {
            Puzzle puzzle = view.getPuzzle();
            if (    (puzzle.getCellAt(selected) == 0 && value != 0) ||
                    (puzzle.getCellAt(selected) != 0 && value == 0)) {
                puzzle.setCellAt(selected, value);
                view.render(puzzle);
            }
        }
    }
}
