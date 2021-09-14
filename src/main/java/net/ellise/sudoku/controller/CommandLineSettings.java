package net.ellise.sudoku.controller;

import net.ellise.sudoku.controller.command.NewCommand;
import net.ellise.sudoku.controller.command.OpenCommand;
import net.ellise.sudoku.controller.command.SaveCommand;
import net.ellise.sudoku.controller.command.SolverCommand;
import net.ellise.sudoku.io.ArrayPuzzleReader;
import net.ellise.sudoku.io.MapPuzzleReader;
import net.ellise.sudoku.io.PuzzleReader;
import net.ellise.sudoku.io.PuzzleWriter;
import net.ellise.sudoku.io.composite.source.Source;
import net.ellise.sudoku.model.Command;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.model.puzzle.ArrayPuzzleImpl;
import net.ellise.sudoku.model.puzzle.MapPuzzleImpl;
import net.ellise.sudoku.solver.BacktrackingSolver;
import net.ellise.sudoku.view.View;
import net.ellise.sudoku.view.cli.CliView;
import net.ellise.sudoku.view.swing.SwingView;

import java.util.HashMap;
import java.util.Map;

public class CommandLineSettings {
    private final CommandLineArgs args;

    public CommandLineSettings(CommandLineArgs args) {
        this.args = args;
    }

    public PuzzleReader getPuzzleReader(Source source) {
        if (args.isArrayBased()) {
            return new ArrayPuzzleReader(source);
        } else {
            return new MapPuzzleReader(source);
        }
    }

    public PuzzleWriter getPuzzleWriter() {
        return new PuzzleWriter();
    }

    public Puzzle newEmptyPuzzle() {
        Puzzle result;
        if (args.isArrayBased()) {
            int[][] data = new int[Puzzle.HEIGHT.getMax()][];
            for (int i = 0; i < data.length; i++) {
                data[i] = new int[Puzzle.WIDTH.getMax()];
            }
            result = new ArrayPuzzleImpl(data);
        } else {
            result = new MapPuzzleImpl(new HashMap<>());
        }
        return result;
    }

    public View getView() {
        if (args.isTerminalBased()) {
            return new CliView(System.out);
        } else {
            SwingView view = new SwingView();
            Command solverCommand = new SolverCommand(view, new BacktrackingSolver());
            Map<String,Command> menuCommands = getMenuCommands(view);
            view.initialise(menuCommands);
            view.addKeyListener(' ', solverCommand);
            return view;
        }
    }

    public Map<String,Command> getMenuCommands(View view) {
        Map<String,Command> menuCommands = new HashMap<>();
        menuCommands.put("New", new NewCommand(this, view));
        menuCommands.put("Open", new OpenCommand(this, view));
        menuCommands.put("SaveAs", new SaveCommand(this, view));
        return menuCommands;
    }
}
