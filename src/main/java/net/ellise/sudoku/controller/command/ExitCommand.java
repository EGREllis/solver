package net.ellise.sudoku.controller.command;

import net.ellise.sudoku.model.Command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
