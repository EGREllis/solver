package net.ellise.sudoku.controller;

import net.ellise.sudoku.controller.command.*;
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
        SwingView view = new SwingView();

        Map<String,Command> menuCommands = getMenuCommands(view);
        view.initialise(menuCommands);

        Map<String, Command> keyboardCommands = getKeyboardCommands(view);
        view.addKeyListeners(keyboardCommands);

        return view;
    }

    public Map<String,Command> getMenuCommands(View view) {
        Map<String,Command> menuCommands = new HashMap<>();
        menuCommands.put("New", new NewCommand(this, view));
        menuCommands.put("Open", new OpenCommand(this, view));
        menuCommands.put("SaveAs", new SaveCommand(this, view));
        menuCommands.put("Exit", new ExitCommand());
        return menuCommands;
    }

    public Map<String,Command> getKeyboardCommands(View view) {
        Map<String,Command> keyboardCommands = new HashMap<>();
        keyboardCommands.put(" ", new SolverCommand(view, new BacktrackingSolver()));
        keyboardCommands.put("0", new DigitCommand(view, 0));
        keyboardCommands.put("1", new DigitCommand(view, 1));
        keyboardCommands.put("2", new DigitCommand(view, 2));
        keyboardCommands.put("3", new DigitCommand(view, 3));
        keyboardCommands.put("4", new DigitCommand(view, 4));
        keyboardCommands.put("5", new DigitCommand(view, 5));
        keyboardCommands.put("6", new DigitCommand(view, 6));
        keyboardCommands.put("7", new DigitCommand(view, 7));
        keyboardCommands.put("8", new DigitCommand(view, 8));
        keyboardCommands.put("9", new DigitCommand(view, 9));
        return keyboardCommands;
    }
}
