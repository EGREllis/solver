package net.ellise.sudoku.controller;

import net.ellise.sudoku.io.composite.source.ClasspathSource;
import net.ellise.sudoku.solver.BacktrackingSolver;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.View;

public class App 
{
    public static void main( String[] args ) throws Exception {
        CommandLineArgs cli = CommandLineArgs.parse(args);
        CommandLineSettings settings = new CommandLineSettings(cli);

        View view = settings.getView();

        Puzzle puzzle = settings.getPuzzleReader(new ClasspathSource()).readPuzzle(cli.getPuzzlePath());
        view.render(puzzle);

        Puzzle solved = puzzle.deepCopy();
        BacktrackingSolver solver = new BacktrackingSolver();
        if (solver.solve(solved)) {
            System.out.println("Has been solved:");
            //view.render(puzzle);
        } else {
            System.out.println("Has not been solved:");
            //view.render(puzzle);
        }
    }
}
