package net.ellise.sudoku.controller.command;

import net.ellise.sudoku.model.Command;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.model.Solver;
import net.ellise.sudoku.view.View;

public class SolverCommand implements Command {
    private final View view;
    private final Solver solver;

    public SolverCommand(View view, Solver solver) {
        this.view = view;
        this.solver = solver;
    }

    @Override
    public void execute() {
        Puzzle puzzle = view.getPuzzle();
        solver.solve(puzzle);
        view.render(puzzle);
    }
}
