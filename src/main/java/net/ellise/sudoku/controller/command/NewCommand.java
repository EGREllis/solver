package net.ellise.sudoku.controller.command;

import net.ellise.sudoku.controller.CommandLineSettings;
import net.ellise.sudoku.model.Command;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.View;

public class NewCommand implements Command {
    private final View view;
    private final CommandLineSettings settings;

    public NewCommand(CommandLineSettings settings, View view) {
        this.settings = settings;
        this.view = view;
    }

    @Override
    public void execute() {
        Puzzle puzzle = settings.newEmptyPuzzle();
        view.render(puzzle);
    }
}
